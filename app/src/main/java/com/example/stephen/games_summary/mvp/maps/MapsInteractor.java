package com.example.stephen.games_summary.mvp.maps;

import com.example.stephen.games_summary.model.Map.MapRequest;

import io.reactivex.Observable;

/**
 * Created by Stephen on 09/08/2017.
 */

public interface MapsInteractor {

    Observable<MapRequest> getMapsRequest(String address);
}
