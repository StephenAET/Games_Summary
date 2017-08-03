package com.example.stephen.games_summary.mvp.gameList;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.example.stephen.games_summary.mvp.MvpPresenter;

/**
 * Game List Presenter implements MVP Presenter
 * Game List View/s can be attached to this presenter
 *
 */
public interface GameListPresenter extends MvpPresenter<GameListView> {

    /**
     * RequestArray the Games List from the interactor
     */
    void performGameList(String filter);
}