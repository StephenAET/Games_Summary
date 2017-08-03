package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.model.RequestSingle;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * Game Interactor performs a request and gets a Game
 */
public interface GameInteractor {

    /**
     * Get a Game RequestArray
     * @param id
     * @return
     */
    Observable<RequestSingle> getGameRequest(String id);
}
