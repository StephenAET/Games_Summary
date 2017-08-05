package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.model.Result;

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

    Result getGameFromRealm(int id);
    void saveGameToRealm(Result result);
    void deleteGameFromRealm(int id);
}
