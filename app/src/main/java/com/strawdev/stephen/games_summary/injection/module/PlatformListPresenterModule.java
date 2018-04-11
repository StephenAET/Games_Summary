package com.strawdev.stephen.games_summary.injection.module;

import com.strawdev.stephen.games_summary.mvp.platformList.PlatformListInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Stephen on 09/08/2017.
 */

@Module
public class PlatformListPresenterModule {

    @Provides
    public PlatformListInteractorImpl providePlatformListInteractor(){
        return new PlatformListInteractorImpl();
    }
}
