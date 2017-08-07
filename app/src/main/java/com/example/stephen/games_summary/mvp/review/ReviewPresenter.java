package com.example.stephen.games_summary.mvp.review;

import com.example.stephen.games_summary.mvp.MvpPresenter;

/**
 * Created by Stephen on 07/08/2017.
 */

/**
 * Review Presenter implements MVP Presenter
 * Review View/s can be attached to this presenter
 */
public interface ReviewPresenter extends MvpPresenter<ReviewView> {

    /**
     * Request the Review from the interactor
     */
    void performReview(String id);
}
