package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.BaseInteractor;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameInteractorImpl extends BaseInteractor implements GameInteractor {

    @Override
    public Observable<Request> getGameRequest(String id) {
        return getGiantBombApi().getGameRequest(id, GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON);
    }
}
