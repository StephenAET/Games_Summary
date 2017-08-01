package com.example.stephen.games_summary.mvp.gameList;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.MvpView;

/**
 * Game List View is a MVP managed View that can be attached to a MVP Presenter
 */
public interface GameListView extends MvpView {

    /**
     * Get back the Game List Request Data and do something with it
     * @param request The Game List Request Data
     */
    void onFetchDataSuccess(Request request);

}
