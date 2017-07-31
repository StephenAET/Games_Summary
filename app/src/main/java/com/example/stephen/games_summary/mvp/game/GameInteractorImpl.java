package com.example.stephen.games_summary.mvp.game;

import android.util.Log;

import com.example.stephen.games_summary.giantBomb.BaseInteractor;
import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.GameRequest;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameInteractorImpl extends BaseInteractor implements GameInteractor {

    @Override
    public Observable<GameRequest> getGameRequest(String id) {

        Log.i("REEE",id);


        return getGiantBombApi().getGameRequest(id, GiantBombConstants.V_API_KEY, GiantBombConstants.V_FORMAT);
    }
}
