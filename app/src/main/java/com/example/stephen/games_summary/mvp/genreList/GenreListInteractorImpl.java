package com.example.stephen.games_summary.mvp.genreList;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.BaseInteractor;

import io.reactivex.Observable;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GenreListInteractorImpl extends BaseInteractor implements GenreListInteractor {

    @Override
    public Observable<Request> getGenreListRequest(String filter) {
        return getGiantBombApi().getGenresRequest(GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON);
    }
}