package com.example.stephen.games_summary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by Stephen on 03/08/2017.
 */

public class GameFragment extends Fragment implements GameView {

    GamePresenter gamePresenter;
    GameInteractor gameInteractor;

    TextView gameTitle;
    TextView gameDescription;
    TextView gameReleaseDate;
    TextView gamePlatforms;


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

        gameId = getArguments().getInt("id");

        gameInteractor = new GameInteractorImpl();
        gamePresenter = new GamePresenterImpl(gameInteractor);
        gamePresenter.attachView(this);
        gamePresenter.performGame(Integer.toString(gameId));
    }

    @Override
    public void onFetchDataStarted() {
        //Toast.makeText(getActivity(), "Starting", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFetchDataError(Throwable e) {
        Toast.makeText(getActivity(), "Ugh " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFetchDataCompleted() {
    }

    @Override
    public void onFetchDataSuccess(RequestSingle requestSingle) {

        Result result = requestSingle.getResult();
        gameTitle.setText(result.getName());


        if (result.getDescription() != null)
        {
            Spanned spanned;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                spanned = Html.fromHtml(result.getDescription(), Html.FROM_HTML_MODE_LEGACY);
            } else {
                spanned = Html.fromHtml(result.getDescription());
            }
            gameDescription.setText(spanned);
        }


        String date = result.getOriginalReleaseDate();
        date = date.substring(0, Math.min(date.length(), 10));
        gameReleaseDate.setText(date);

        String platforms = "";

        for(Platform platform : result.getPlatforms()){

            platforms = platforms + platform.getAbbreviation() +", ";
        }

        gamePlatforms.setText(platforms);
    }
}
