package com.example.stephen.games_summary.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.stephen.games_summary.R;
import com.example.stephen.games_summary.model.Platform;
import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.model.Result;
import com.example.stephen.games_summary.mvp.game.GameInteractor;
import com.example.stephen.games_summary.mvp.game.GameInteractorImpl;
import com.example.stephen.games_summary.mvp.game.GamePresenter;
import com.example.stephen.games_summary.mvp.game.GamePresenterImpl;
import com.example.stephen.games_summary.mvp.game.GameView;
import com.squareup.picasso.Picasso;

/**
 * Created by Stephen on 03/08/2017.
 */

public class GameFragment extends Fragment implements GameView {

    GamePresenter gamePresenter;
    GameInteractor gameInteractor;

    ScrollView scrollView;

    TextView gameTitle;
    TextView gameDescription;
    TextView gameReleaseDate;
    TextView gamePlatforms;

    ImageView gameBackdrop;
    ImageView gamePoster;

    ProgressBar progressBar;

    Result result;

    ImageView bookmark;

    FloatingActionButton saveButton;

    //Button buttonOfNoImportance;

    FrameLayout reviewContainer;

    int gameId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameTitle = view.findViewById(R.id.tv_single_game_title);
        gameDescription = view.findViewById(R.id.tv_single_game_description);
        gameReleaseDate = view.findViewById(R.id.tv_single_game_release_date);
        gamePlatforms = view.findViewById(R.id.tv_single_game_platforms);
        gameBackdrop = view.findViewById(R.id.img_single_game_image);
        gamePoster = view.findViewById(R.id.img_single_game_box);
        progressBar = view.findViewById(R.id.pb_single);

        reviewContainer = view.findViewById(R.id.review_container);

        /*
        buttonOfNoImportance = view.findViewById(R.id.btn_of_no_importance);
        buttonOfNoImportance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new DeveloperMapFragment())
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });*/

        scrollView = view.findViewById(R.id.sv_game);
        scrollView.setVisibility(View.INVISIBLE);

        gameId = getArguments().getInt("id");

        gameInteractor = new GameInteractorImpl();
        gamePresenter = new GamePresenterImpl(gameInteractor);
        gamePresenter.attachView(this);
        gamePresenter.performGame(Integer.toString(gameId));

        bookmark = view.findViewById(R.id.img_single_game_bookmark);
        if (gameInteractor.getGameFromRealm(gameId) != null) {
            bookmark.setVisibility(View.VISIBLE);
        } else {
            bookmark.setVisibility(View.INVISIBLE);
        }

        saveButton = view.findViewById(R.id.fb_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (result != null) {

                    CoordinatorLayout coordinatorLayout = getActivity().findViewById(R.id.coordinator);

                    if (gameInteractor.getGameFromRealm(gameId) == null) {
                        boolean success = gameInteractor.saveGameToRealm(result);

                        if (success) {
                            if (coordinatorLayout != null) {
                                Snackbar.make(coordinatorLayout, R.string.game_favorite_success, Snackbar.LENGTH_SHORT).show();
                            }
                            bookmark.setVisibility(View.VISIBLE);
                        } else {

                            if (coordinatorLayout != null) {
                                Snackbar.make(coordinatorLayout, R.string.game_favorite_failure, Snackbar.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        boolean success = gameInteractor.deleteGameFromRealm(gameId);

                        if (success) {
                            if (coordinatorLayout != null) {
                                Snackbar.make(coordinatorLayout, R.string.game_unfavorite_success, Snackbar.LENGTH_SHORT).show();
                            }
                            bookmark.setVisibility(View.INVISIBLE);
                        } else {
                            if (coordinatorLayout != null) {
                                Snackbar.make(coordinatorLayout, R.string.game_unfavorite_failure, Snackbar.LENGTH_SHORT).show();
                            }

                        }
                    }
                }
            }
        });
        saveButton.setVisibility(View.GONE);

        //if (gameInteractor.getGameFromRealm(gameId) != null){
        //    saveButton.setBackground();
        //}

    }

    @Override
    public void onFetchDataStarted() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onFetchDataError(Throwable e) {
        Snackbar.make(getActivity().findViewById(R.id.coordinator) , e.getLocalizedMessage(), Snackbar.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);

        CoordinatorLayout coordinatorLayout = getActivity().findViewById(R.id.coordinator);
        if (coordinatorLayout != null) {
            Snackbar.make(coordinatorLayout, R.string.game_fragment_fetch_error, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchDataCompleted() {
        progressBar.setVisibility(View.GONE);

        CoordinatorLayout coordinatorLayout = getActivity().findViewById(R.id.coordinator);
        if (coordinatorLayout != null) {
            Snackbar.make(coordinatorLayout, R.string.game_fragment_fetch_completed, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchDataSuccess(RequestSingle requestSingle) {
        scrollView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

        result = requestSingle.getResult();
        gameTitle.setText(result.getName());

        //Some results don't have images unfortunately, so this handles that exception
        if (result.getImage() != null) {

            Boolean gameBackDropSet = false;

            //In the event the URLs are malformed, the placeholder is used instead
            try {
                if (result.getImage().getScreenUrl() != null) {

                    Picasso.with(getActivity())
                            .load(result.getImage().getScreenUrl())
                            .centerCrop()
                            .fit()
                            .into(gameBackdrop);

                    gameBackdrop.setColorFilter(Color.GRAY, PorterDuff.Mode.DARKEN);
                    gameBackDropSet = true;
                }
                if (result.getImage().getSmallUrl() != null) {

                    Picasso.with(getActivity())
                            .load(result.getImage().getSmallUrl())
                            .centerCrop()
                            .fit()
                            .into(gamePoster);
                }
            } catch (Exception e) {
                if (!gameBackDropSet) {
                    gameBackdrop.setImageResource(R.drawable.missing_visual);
                }
                gamePoster.setImageResource(R.drawable.missing_visual);
            }
        } else {
            gameBackdrop.setImageResource(R.drawable.missing_visual);
            gamePoster.setImageResource(R.drawable.missing_visual);
        }

        if (result.getDescription() != null) {
            String description = result.getDescription().replaceAll("<img.+?>", "");
            Spanned spanned;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                spanned = Html.fromHtml(description, Html.FROM_HTML_MODE_LEGACY);
            } else {
                spanned = Html.fromHtml(description);
            }
            gameDescription.setText(spanned);
        }

        if (result.getOriginalReleaseDate() != null) {
            String date = result.getOriginalReleaseDate();
            date = date.substring(0, Math.min(date.length(), 10));
            gameReleaseDate.setText(date);
        }

        if (result.getPlatforms() != null) {
            String platforms = "";
            for (Platform platform : result.getPlatforms()) {
                platforms = platforms + platform.getAbbreviation() + ", ";
            }
            gamePlatforms.setText(platforms);
        }

        saveButton.setVisibility(View.VISIBLE);

        if (result.getReviews() != null && result.getReviews().size() > 0) {

            try {
                int id = result.getReviews().get(0).getId();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);

                ReviewFragment reviewFragment = new ReviewFragment();
                reviewFragment.setArguments(bundle);

                this.getFragmentManager().beginTransaction()
                        .replace(reviewContainer.getId(), reviewFragment)
                        .commit();
            } catch (Exception e){
                Log.e("Game Fragment", e.getLocalizedMessage());
                reviewContainer.setVisibility(View.INVISIBLE);
            }
        } else {
            reviewContainer.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gamePresenter.detachView();
    }
}
