package com.example.stephen.games_summary;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.stephen.games_summary.adapter.GameListAdapter;
import com.example.stephen.games_summary.model.Result;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Stephen on 08/08/2017.
 */

public class GenericListFragment extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setRetainInstance(true);

        progressBar = view.findViewById(R.id.pb_game_list);
        progressBar.setVisibility(View.GONE);

        int columns = 2;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            columns = 3;
        }

        //Setup the RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(columns, 1));
        recyclerView.setAdapter(new GameListAdapter(getActivity(), new ArrayList<Result>(), null));

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_game_list);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int columns = 2;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            columns = 3;
        }
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(columns, 1));
    }

    protected List<Result> getFavorites(){
        List<Result> results = new ArrayList<>();
        RealmHelper realmHelper = new RealmHelper(Realm.getDefaultInstance());
        try {
            realmHelper.getRealmObjects(Result.class).forEach(result ->
                    results.add((Result) result));
        } catch (Exception e){
            Log.e("Oof", e.getLocalizedMessage());
        }
        return results;
    }
}
