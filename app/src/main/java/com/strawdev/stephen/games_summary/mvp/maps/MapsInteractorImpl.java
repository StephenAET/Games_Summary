package com.strawdev.stephen.games_summary.mvp.maps;

import com.strawdev.stephen.games_summary.googleMaps.GoogleMapsApi;
import com.strawdev.stephen.games_summary.googleMaps.GoogleMapsConstants;
import com.strawdev.stephen.games_summary.model.Map.MapRequest;
import com.strawdev.stephen.games_summary.util.RxSchedulers;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stephen on 09/08/2017.
 */

public class MapsInteractorImpl implements MapsInteractor {

    RxSchedulers rxSchedulers = new RxSchedulers();

    GoogleMapsApi googleMapsApi;

    public MapsInteractorImpl() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GoogleMapsConstants.BASE_URL)//Pass the Base URL here for making requests
                .addConverterFactory(gsonConverterFactory)//Create and Pass the Converter Factory for interpreting the RequestArray Data
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//Create and Pass the Call Adapter Factory for
                .client(okHttpClient)
                .build();

        googleMapsApi = retrofit.create(GoogleMapsApi.class);
    }

    @Override
    public Observable<MapRequest> getMapsRequest(String address) {
        return googleMapsApi.getGoogleMapsRequestTest(address, GoogleMapsConstants.KEY_VALUE);
    }
}
