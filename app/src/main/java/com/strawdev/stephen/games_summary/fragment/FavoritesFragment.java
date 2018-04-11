package com.strawdev.stephen.games_summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.strawdev.stephen.games_summary.adapter.GameListAdapter;
import com.strawdev.stephen.games_summary.model.Result;

import java.util.List;

/**
 * Created by Stephen on 08/08/2017.
 */

public class FavoritesFragment extends GenericListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Result> favorites = getFavorites();

        recyclerView.swapAdapter(new GameListAdapter(getActivity(), favorites, null), false);
    }
}