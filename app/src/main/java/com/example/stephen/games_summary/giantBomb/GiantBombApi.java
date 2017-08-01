package com.example.stephen.games_summary.giantBomb;

import com.example.stephen.games_summary.model.Request;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Stephen on 31/07/2017.
 */

public interface GiantBombApi {

    /**
     * Get Filtered Game List
     *
     * @param api_key
     * @param format
     * @param filter
     * @return
     */
    @GET(GiantBombConstants.BASE_URL +
            GiantBombConstants.GAMES_PATH)
    public Observable<Request> getGameListRequest(
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format,
            @Query(GiantBombConstants.FILTER_QUERY) String filter
    );

    /**
     * Get Game by ID
     *
     * @param id
     * @param api_key
     * @param format
     * @return
     */
    @GET(GiantBombConstants.BASE_URL +
            GiantBombConstants.GAME_PATH + "{" +
            GiantBombConstants.ID_PATH + "}/")
    public Observable<Request> getGameRequest(
            @Path("id") String id,
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format
    );

    /**
     * Get Genres
     *
     * @param api_key
     * @param format
     * @return
     */
    @GET(GiantBombConstants.BASE_URL +
            GiantBombConstants.GENRES_PATH)
    public Observable<Request> getGenresRequest(
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format
    );
}
