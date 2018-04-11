package com.strawdev.stephen.games_summary.mvp.game;

import com.strawdev.stephen.games_summary.model.RequestSingle;
import com.strawdev.stephen.games_summary.model.Result;

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
    Observable<RequestSingle> getGameRequest(String id);

    Result getGameFromRealm(int id);
    boolean saveGameToRealm(Result result);
    boolean deleteGameFromRealm(int id);
}
