package com.example.stephen.games_summary.giantBomb;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stephen on 31/07/2017.
 */

public class BaseInteractor {

    GiantBombApi giantBombApi;

    public BaseInteractor(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")//Pass the Base URL here for making requests
                .addConverterFactory(gsonConverterFactory)//Create and Pass the Converter Factory for interpreting the Request Data
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//Create and Pass the Call Adapter Factory for
                .client(okHttpClient)
                .build();

        giantBombApi = retrofit.create(GiantBombApi.class);
    }

    public GiantBombApi getGiantBombApi(){
        return giantBombApi;
    }
}
