package com.example.stephen.games_summary.giantBomb;

import com.example.stephen.games_summary.model.RequestArray;
import com.example.stephen.games_summary.model.RequestSingle;

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
    public Observable<RequestArray> getGameListRequest(
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format,
            @Query(GiantBombConstants.FILTER_QUERY) String filter,
            @Query(GiantBombConstants.SORT_QUERY) String sort
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
    public Observable<RequestSingle> getGameRequest(
            @Path(GiantBombConstants.ID_PATH) String id,
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
            GiantBombConstants.PLATFORMS_PATH)
    public Observable<RequestArray> getPlatformsRequest(
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format,
            @Query(GiantBombConstants.SORT_QUERY) String sort
    );


    /**
     * End Point 4 - Get Review ,
     *
     * @param api_key
     * @param format
     * @return
     */
    @GET(GiantBombConstants.BASE_URL +
            GiantBombConstants.REVIEWS_PATH + "{" +
            GiantBombConstants.ID_PATH + "}/")
    public Observable<RequestSingle> getReviewRequest(
            @Path(GiantBombConstants.ID_PATH) String id,
            @Query(GiantBombConstants.API_KEY_QUERY) String api_key,
            @Query(GiantBombConstants.FORMAT_QUERY) String format
    );

    /*
     * End Point 5 - Get
     */
}
