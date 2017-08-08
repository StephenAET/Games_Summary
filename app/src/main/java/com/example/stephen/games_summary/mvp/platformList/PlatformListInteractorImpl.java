package com.example.stephen.games_summary.mvp.platformList;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.RequestArray;
import com.example.stephen.games_summary.mvp.BaseInteractor;

import io.reactivex.Observable;

/**
 * Created by Stephen on 01/08/2017.
 */

public class PlatformListInteractorImpl extends BaseInteractor implements PlatformListInteractor {

    @Override
    public Observable<RequestArray> getPlatformListRequest() {
        return getGiantBombApi().getPlatformsRequest(GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON, GiantBombConstants.DATE_DESC_PLATFORM);
    }
}