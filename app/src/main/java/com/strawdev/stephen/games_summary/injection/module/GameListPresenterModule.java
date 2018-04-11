package com.strawdev.stephen.games_summary.injection.module;

import com.strawdev.stephen.games_summary.mvp.gameList.GameListInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Stephen on 09/08/2017.
 */

/**
 * This module provides the objects required by the Game List Presenter
 */
@Module
public class GameListPresenterModule {

    @Provides
    public GameListInteractorImpl getGameListInteractor(){
        return new GameListInteractorImpl();
    }
}
