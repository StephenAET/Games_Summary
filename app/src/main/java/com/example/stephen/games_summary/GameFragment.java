package com.example.stephen.games_summary;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    CardView mainCard;

    TextView gameTitle;
    TextView gameDescription;
    TextView gameReleaseDate;
    TextView gamePlatforms;

    ImageView gameBackdrop;
    ImageView gamePoster;

    ProgressBar progressBar;

    Result result;

    FloatingActionButton saveButton;

    int gameId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        //Toast.makeText(getActivity(), gameId+"",Toast.LENGTH_SHORT).show();

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

        //saveButton = view.findViewById(R.id.bt_single_save);


        mainCard = view.findViewById(R.id.cv_single);
        mainCard.setVisibility(View.INVISIBLE);

        gameId = getArguments().getInt("id");

        gameInteractor = new GameInteractorImpl();
        gamePresenter = new GamePresenterImpl(gameInteractor);
        gamePresenter.attachView(this);
        gamePresenter.performGame(Integer.toString(gameId));

        saveButton = view.findViewById(R.id.fb_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO Handle Realm Issue
                //if (result != null) {

                    //if (gameInteractor.getGameFromRealm(gameId) == null) {
                    //    gameInteractor.saveGameToRealm(result);
                    //} else {
                    //    gameInteractor.deleteGameFromRealm(gameId);
                    //}
                //}
            }
        });

        //if (gameInteractor.getGameFromRealm(gameId) != null){
        //    saveButton.setBackground();
        //}

    }

    @Override
    public void onFetchDataStarted() {
        //Toast.makeText(getActivity(), "Starting", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onFetchDataError(Throwable e) {
        Toast.makeText(getActivity(), "Ugh " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataCompleted() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataSuccess(RequestSingle requestSingle) {

        mainCard.setVisibility(View.VISIBLE);

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
    }
}
