package com.example.stephen.games_summary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stephen.games_summary.adapter.GameListAdapter;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.model.Result;
import com.example.stephen.games_summary.mvp.gameList.GameListInteractor;
import com.example.stephen.games_summary.mvp.gameList.GameListInteractorImpl;
import com.example.stephen.games_summary.mvp.gameList.GameListPresenter;
import com.example.stephen.games_summary.mvp.gameList.GameListPresenterImpl;
import com.example.stephen.games_summary.mvp.gameList.GameListView;

import java.util.ArrayList;

/**
 * Created by Stephen on 02/08/2017.
 */

public class GameListFragment extends Fragment implements GameListView {

    GameListPresenter gameListPresenter;
    GameListInteractor gameListInteractor;
    RecyclerView recyclerView;

    //ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //progressBar = view.findViewById(R.id.pb_game_list);

        //Find Recycler View in Fragment Layout
        recyclerView = view.findViewById(R.id.recycler_view);

        //Set the Recycler's Layout Manager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));

        Request request = new Request();
        request.setResults(new ArrayList<Result>(0));
        recyclerView.setAdapter(new GameListAdapter(getActivity(), request));

        //Setup the Interactor and Presenter
        gameListInteractor = new GameListInteractorImpl();
        gameListPresenter = new GameListPresenterImpl(gameListInteractor);
        gameListPresenter.attachView(this);

        //Populate the game list with a search request for recent games

        Log.i("Request","BEGIN");
        gameListPresenter.performGameList("name:persona");
    }

    @Override
    public void onFetchDataStarted() {
        //progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFetchDataError(Throwable e) {
        //progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataCompleted() {
        //progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataSuccess(Request request) {

        Log.i("Request","SUCCESS");

        for(Result result : request.getResults()){
            Log.i("FUCK",result.getName());
        }
        recyclerView.setAdapter(new GameListAdapter(getActivity(), request));
    }
}
