package com.example.stephen.games_summary.mvp.gameList;

import com.example.stephen.games_summary.model.Request;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * Game Interactor performs a request and gets a Game List
 */
public interface GameListInteractor {

    /**
     * Get a Game List Request
     * @param filter
     * @return
     */
    Observable<Request> getGameListRequest(String filter);
}