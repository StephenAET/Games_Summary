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

    /**
     * Get a Game Result from the Realm
     * The result wont be complete due to abstraction but it will have the essential data required
     *
     * @param id
     * @return
     */
    @Override
    public Result getGameFromRealm(int id) {
        return (Result) realmHelper.getRealmObject(Result.class, id);
    }

    @Override
    public boolean saveGameToRealm(Result result) {
        return realmHelper.saveRealmObjectToRealm(result);
    }

    @Override
    public boolean deleteGameFromRealm(int id) {
        return realmHelper.deleteObjectFromRealm(Result.class, id);
    }
}
