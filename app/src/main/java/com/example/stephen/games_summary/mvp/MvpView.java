package com.example.stephen.games_summary.mvp;

/**
 * Created by Stephen on 31/07/2017.
 */

public interface MvpView {

    /**
     * When a Request Begins
     */
    void onFetchDataStarted();

    /**
     * When the Request Fails
     * @param e
     */
    void onFetchDataError(Throwable e);

    /**
     * When the Request Completes
     */
    void onFetchDataCompleted();
}
