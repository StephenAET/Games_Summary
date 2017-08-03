package com.example.stephen.games_summary.mvp.gameList;

import com.example.stephen.games_summary.model.RequestArray;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * Game Interactor performs a request and gets a Game List
 */
public interface GameListInteractor {

    /**
     * Get a Game List RequestArray
     * @param filter
     * @return
     */
    Observable<RequestArray> getGameListRequest(String filter);
}