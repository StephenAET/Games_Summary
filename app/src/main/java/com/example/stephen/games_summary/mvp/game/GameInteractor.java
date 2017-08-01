package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.model.Request;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * Game Interactor performs a request and gets a Game
 */
public interface GameInteractor {

    /**
     * Get a Game Request
     * @param id
     * @return
     */
    Observable<Request> getGameRequest(String id);
}
