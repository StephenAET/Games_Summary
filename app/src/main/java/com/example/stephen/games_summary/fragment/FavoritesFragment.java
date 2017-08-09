package com.example.stephen.games_summary.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.stephen.games_summary.adapter.GameListAdapter;

/**
 * Created by Stephen on 08/08/2017.
 */

public class FavoritesFragment extends GenericListFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.swapAdapter(new GameListAdapter(getActivity(), getFavorites(), null), false);
    }
}