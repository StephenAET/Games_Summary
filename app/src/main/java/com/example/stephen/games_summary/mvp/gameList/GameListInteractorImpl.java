package com.example.stephen.games_summary.mvp.gameList;

import com.example.stephen.games_summary.giantBomb.BaseInteractor;
import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.GameListRequest;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameListInteractorImpl extends BaseInteractor implements GameListInteractor {


    @Override
    public Observable<GameListRequest> getGameListRequest() {
        return getGiantBombApi().getGameListRequest(GiantBombConstants.V_API_KEY, GiantBombConstants.V_FORMAT);
    }

    @Override
    public Observable<GameListRequest> getGameListRequest(String filter) {
        return getGiantBombApi().getGameListRequest(GiantBombConstants.V_API_KEY, GiantBombConstants.V_FORMAT, filter);
    }
}
