package com.strawdev.stephen.games_summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;

import com.strawdev.stephen.games_summary.R;
import com.strawdev.stephen.games_summary.adapter.GameListAdapter;
import com.strawdev.stephen.games_summary.model.RequestArray;
import com.strawdev.stephen.games_summary.model.Result;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListInteractor;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListInteractorImpl;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListPresenter;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListPresenterImpl;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen on 02/08/2017.
 */

public class GameListFragment extends GenericListFragment implements GameListView {

    GameListPresenter gameListPresenter;
    GameListInteractor gameListInteractor;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Setup the Interactor and Presenter
        gameListInteractor = new GameListInteractorImpl();
        gameListPresenter = new GameListPresenterImpl(gameListInteractor);
        gameListPresenter.attachView(this);

        //Get the Search Query and Perform the Request
        String header = getArguments().getString("header");
        String query = getArguments().getString("query");
        gameListPresenter.performGameList(header + ":" + query);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gameListPresenter.performGameList(header + ":" + query);
            }
        });
    }

    @Override
    public void onFetchDataStarted() {
        Log.i("RequestArray", "Started");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFetchDataError(Throwable e) {
        Log.i("RequestArray", "Error : " + e.getLocalizedMessage());
        progressBar.setVisibility(View.GONE);

        CoordinatorLayout coordinatorLayout = getActivity().findViewById(R.id.coordinator);
        if (coordinatorLayout != null) {
            Snackbar.make(coordinatorLayout, R.string.game_list_fragment_fetch_error, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchDataCompleted() {
        Log.i("RequestArray", "Completed");
        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);

        CoordinatorLayout coordinatorLayout = getActivity().findViewById(R.id.coordinator);
        if (coordinatorLayout != null) {
            Snackbar.make(coordinatorLayout, R.string.game_list_fragment_fetch_success, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFetchDataSuccess(RequestArray requestArray) {
        Log.i("RequestArray", "SUCCESS");
        List<Integer> bookmarks = new ArrayList<>();
        for (Result result : getFavorites()) {
            bookmarks.add(result.getId());
        }
        recyclerView.swapAdapter(new GameListAdapter(getActivity(), requestArray.getResults(), bookmarks), false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gameListPresenter.detachView();
    }
}
