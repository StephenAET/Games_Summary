package com.example.stephen.games_summary;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.stephen.games_summary.adapter.GameListAdapter;
import com.example.stephen.games_summary.model.RequestArray;
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

    ProgressBar progressBar;

    String lastSearch = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.pb_game_list);

        //Find Recycler View in Fragment Layout
        recyclerView = view.findViewById(R.id.recycler_view);

        progressBar.setVisibility(View.GONE);

        int columns = 2;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            columns = 3;
        }

        //Set the Recycler's Layout Manager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(columns, 1));

        RequestArray requestArray = new RequestArray();
        requestArray.setResults(new ArrayList<Result>(0));

        recyclerView.setAdapter(new GameListAdapter(getActivity(), requestArray));

        //Setup the Interactor and Presenter
        gameListInteractor = new GameListInteractorImpl();
        gameListPresenter = new GameListPresenterImpl(gameListInteractor);
        gameListPresenter.attachView(this);
    }

    @Override
    public void onFetchDataStarted() {
        Log.i("RequestArray","Started");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFetchDataError(Throwable e) {
        Log.i("RequestArray","Error : " + e.getLocalizedMessage());
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataCompleted() {
        Log.i("RequestArray","Completed");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFetchDataSuccess(RequestArray requestArray) {

        Log.i("RequestArray","SUCCESS");

        for(Result result : requestArray.getResults()){
            Log.i("Result", result.getName());
        }

        recyclerView.swapAdapter(new GameListAdapter(getActivity(), requestArray), false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void performSearch(String search){
        lastSearch = search;
        Log.i("RequestArray", "Searching with query " + search);
        gameListPresenter.performGameList("name:"+search);
    }
}
