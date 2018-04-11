package com.strawdev.stephen.games_summary.injection.module;

import com.strawdev.stephen.games_summary.mvp.review.ReviewInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Stephen on 09/08/2017.
 */

@Module
public class ReviewPresenterModule {

    @Provides
    public ReviewInteractorImpl provideReviewInteractor(){
        return new ReviewInteractorImpl();
    }
}
