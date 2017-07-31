package com.example.stephen.games_summary.mvp;

/**
 * Created by Stephen on 31/07/2017.
 */

/**
 * This is used for all MVP managed Presenters
 *
 * @param <V> Each View should have a single Presenter
 */
public interface MvpPresenter <V extends MvpView> {

    /**
     * Attach a view to this Presenter
     * @param mvpView The view to be attached to this presenter
     */
    void attachView(V mvpView);

    /**
     * Detach the view from the presenter (if it has one)
     */
    void detachView();
}