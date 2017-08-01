package com.example.stephen.games_summary.mvp.game;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.example.stephen.games_summary.mvp.MvpPresenter;

/**
 * Game Presenter implements MVP Presenter
 * Game View/s can be attached to this presenter
 *
 */
public interface GamePresenter extends MvpPresenter<GameView> {

    /**
     * Request the Game from the interactor
     */
    void performGame(String id);

}
