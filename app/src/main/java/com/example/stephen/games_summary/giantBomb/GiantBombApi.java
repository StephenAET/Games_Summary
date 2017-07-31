package com.example.stephen.games_summary.giantBomb;

import com.example.stephen.games_summary.model.GameListRequest;
import com.example.stephen.games_summary.model.GameRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Stephen on 31/07/2017.
 */

public interface GiantBombApi {

    /**
     * Unfiltered Game List
     * @param api_key
     * @param format
     * @return
     */
    @GET(GiantBombConstants.BASE_URL)
    public Observable<GameListRequest> getGameListRequest(
            @Query(GiantBombConstants.Q_API_KEY) String api_key,
            @Query(GiantBombConstants.Q_FORMAT) String format
    );

    /**
     * Get Filtered Game List
     * @param api_key
     * @param format
     * @param filter
     * @return
     */
    @GET(GiantBombConstants.BASE_URL)

    public Observable<GameListRequest> getGameListRequest(
            @Query(GiantBombConstants.Q_API_KEY) String api_key,
            @Query(GiantBombConstants.Q_FORMAT) String format,
            @Query(GiantBombConstants.Q_FILTER) String filter
    );

    /**
     *
     * @param id
     * @param api_key
     * @param format
     * @return
     */
    @GET(GiantBombConstants.BASE_URL + "{+"+ GiantBombConstants.P_ID +"+}/")
    public Observable<GameRequest> getGameRequest(
            @Path("id") String id,
            @Query(GiantBombConstants.Q_API_KEY) String api_key,
            @Query(GiantBombConstants.Q_FORMAT) String format
    );
}
