package com.example.stephen.games_summary.mvp.game;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.MvpView;

/**
 * Game View is a MVP managed View that can be attached to a MVP Presenter
 */
public interface GameView extends MvpView {

    /**
     * Get back the Game Request Data and do something with it
     * @param request The Game Request Data
     */
    void onFetchDataSuccess(Request request);

}
