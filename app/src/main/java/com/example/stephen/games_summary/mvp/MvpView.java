package com.example.stephen.games_summary.mvp;

/**
 * Created by Stephen on 31/07/2017.
 */

public interface MvpView {

    /**
     * When a RequestArray Begins
     */
    void onFetchDataStarted();

    /**
     * When the RequestArray Fails
     * @param e
     */
    void onFetchDataError(Throwable e);

    /**
     * When the RequestArray Completes
     */
    void onFetchDataCompleted();
}
