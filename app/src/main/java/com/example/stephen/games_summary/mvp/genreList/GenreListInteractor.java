package com.example.stephen.games_summary.mvp.genreList;

import com.example.stephen.games_summary.model.Request;

import io.reactivex.Observable;

/**
 * Created by Stephen on 01/08/2017.
 */

public interface GenreListInteractor {

    /**
     * Get a Genre List Request
     * @param filter
     * @return
     */
    Observable<Request> getGenreListRequest(String filter);
}
