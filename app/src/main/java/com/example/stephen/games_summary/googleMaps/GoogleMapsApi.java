package com.example.stephen.games_summary.googleMaps;

import com.example.stephen.games_summary.model.Map.MapRequest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Stephen on 09/08/2017.
 */

public interface GoogleMapsApi {

    /**
     * End Point 5 - Get Google Maps Place
     *
     * @param address
     * @param key
     * @return
     */
    @GET(GoogleMapsConstants.BASE_URL
    )
    public Observable<MapRequest> getGoogleMapsRequestTest(
            @Query(GoogleMapsConstants.ADDRESS) String address,
            @Query(GoogleMapsConstants.KEY) String key
            );
}
