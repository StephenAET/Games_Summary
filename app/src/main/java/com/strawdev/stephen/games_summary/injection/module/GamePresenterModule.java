package com.strawdev.stephen.games_summary.injection.module;

import com.strawdev.stephen.games_summary.mvp.game.GameInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Stephen on 09/08/2017.
 */

@Module
public class GamePresenterModule {

    @Provides
    public GameInteractorImpl provideGameInteractor(){
        return new GameInteractorImpl();
    }
}
