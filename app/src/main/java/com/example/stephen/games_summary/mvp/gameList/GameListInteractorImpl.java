package com.example.stephen.games_summary.mvp.gameList;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.BaseInteractor;
import com.example.stephen.games_summary.util.RxSchedulers;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameListInteractorImpl extends BaseInteractor implements GameListInteractor {

    RxSchedulers rxSchedulers = new RxSchedulers();

    @Override
    public Observable<Request> getGameListRequest(String filter) {
        return getGiantBombApi().getGameListRequest(GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON, filter)
                .compose(rxSchedulers.applyObservableAsync());
    }
}
