package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.model.GameRequest;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * Game Interactor performs a request and gets a Game
 */
public interface GameInteractor {

    Observable<GameRequest> getGameRequest(String id);
}
