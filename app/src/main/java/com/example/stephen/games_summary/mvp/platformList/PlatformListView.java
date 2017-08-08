package com.example.stephen.games_summary.mvp.platformList;

import com.example.stephen.games_summary.model.RequestArray;
import com.example.stephen.games_summary.mvp.MvpView;

/**
 * Created by Stephen on 08/08/2017.
 */

public interface PlatformListView extends MvpView{

    /**
     * Get back the Platform List RequestArray Data and do something with it
     * @param requestArray The Game List RequestArray Data
     */
    void onFetchDataSuccess(RequestArray requestArray);
}