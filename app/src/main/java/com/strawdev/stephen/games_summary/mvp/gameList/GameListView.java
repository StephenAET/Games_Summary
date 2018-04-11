package com.strawdev.stephen.games_summary.mvp.gameList;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.strawdev.stephen.games_summary.model.RequestArray;
import com.strawdev.stephen.games_summary.mvp.MvpView;

/**
 * Game List View is a MVP managed View that can be attached to a MVP Presenter
 */
public interface GameListView extends MvpView {

    /**
     * Get back the Game List RequestArray Data and do something with it
     * @param requestArray The Game List RequestArray Data
     */
    void onFetchDataSuccess(RequestArray requestArray);
}
