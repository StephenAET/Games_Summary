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
     * End Point 1 - Get Filtered Game List
     * Get a Games List that can be filtered
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
     * End Point 2 - Get Game by ID
     * This is used for getting data for a specific game by it's ID
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
     * End Point 3 - Get Genres,
     * These can be used for a Drop down for filtering Games Lists by Genre
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

    /**
     * End Point 4 - Get Review?
     * End Point 5 - Get
     */
}
