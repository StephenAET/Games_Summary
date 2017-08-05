package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.model.Result;
import com.example.stephen.games_summary.mvp.BaseInteractor;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameInteractorImpl extends BaseInteractor implements GameInteractor {

    @Override
    public Observable<RequestSingle> getGameRequest(String id) {
        return getGiantBombApi().getGameRequest(id, GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON);
    }

    @Override
    public Result getGameFromRealm(int id) {
        return null;
        //return (Result) realmHelper.getRealmObject(Result.class,Integer.toString(id));
    }

    @Override
    public void saveGameToRealm(Result result) {
        //realmHelper.saveRealmObjectToRealm(result);
    }

    @Override
    public void deleteGameFromRealm(int id) {
        //realmHelper.deleteObjectFromRealm(id);
    }
}
