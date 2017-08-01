package com.example.stephen.games_summary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.model.Result;
import com.example.stephen.games_summary.mvp.gameList.GameListInteractor;
import com.example.stephen.games_summary.mvp.gameList.GameListInteractorImpl;
import com.example.stephen.games_summary.mvp.gameList.GameListPresenter;
import com.example.stephen.games_summary.mvp.gameList.GameListPresenterImpl;
import com.example.stephen.games_summary.mvp.gameList.GameListView;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements GameListView{


    GameListPresenter gameListPresenter;
    GameListInteractor gameListInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);







        gameListInteractor = new GameListInteractorImpl();
        gameListPresenter = new GameListPresenterImpl(gameListInteractor);

        gameListPresenter.attachView(this);

        gameListPresenter.performGameList("name:persona");

        //Initialize Fabric Kit
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);




        //This will be placed in the recycler adapter
        /*
        Picasso.with(this)
                .load("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
                .resize(500, 250)
                .centerCrop()
                .into(imageView);*/

//textView.setText("Nullpointer Exception Test");

    }

    @Override
    public void onFetchDataStarted() {
        Log.i("Giant Bomb Game List", "Starting");
    }

    @Override
    public void onFetchDataError(Throwable e) {
        Log.i("Giant Bomb Game List", "Failure : " + e.getLocalizedMessage());

    }

    @Override
    public void onFetchDataCompleted() {
        Log.i("Giant Bomb Game List", "Success");
    }

    @Override
    public void onFetchDataSuccess(Request request) {

        for(Result result : request.getResults()){
            Log.i(result.getId()+"",result.getName());
        }
    }
}
