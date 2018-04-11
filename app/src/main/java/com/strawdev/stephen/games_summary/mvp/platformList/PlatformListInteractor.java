package com.strawdev.stephen.games_summary.mvp.platformList;

import com.strawdev.stephen.games_summary.model.RequestArray;

import io.reactivex.Observable;

/**
 * Created by Stephen on 01/08/2017.
 */

public interface PlatformListInteractor {

    Observable<RequestArray> getPlatformListRequest();
}
