package com.example.stephen.games_summary.application;

import android.app.Application;

import com.example.stephen.games_summary.injection.component.DaggerGameListPresenterComponent;
import com.example.stephen.games_summary.injection.component.DaggerGamePresenterComponent;
import com.example.stephen.games_summary.injection.component.DaggerReviewPresenterComponent;
import com.example.stephen.games_summary.injection.component.GameListPresenterComponent;
import com.example.stephen.games_summary.injection.component.GamePresenterComponent;
import com.example.stephen.games_summary.injection.component.PlatformListPresenterComponent;
import com.example.stephen.games_summary.injection.component.ReviewPresenterComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Stephen on 04/08/2017.
 */

public class App extends Application {

    GameListPresenterComponent gameListPresenterComponent;
    GamePresenterComponent gamePresenterComponent;
    ReviewPresenterComponent reviewPresenterComponent;
    PlatformListPresenterComponent platformListPresenterComponent;

    public void onCreate() {
        super.onCreate();

        //Initiate Realm instance using Application Context,
        // making it available to the entire Application
        Realm.init(getApplicationContext());

        //Set the Default Realm Configuration
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build());

        gameListPresenterComponent = DaggerGameListPresenterComponent.create();
        gamePresenterComponent = DaggerGamePresenterComponent.create();
        reviewPresenterComponent = DaggerReviewPresenterComponent.create();
        //platformListPresenterComponent = Dagger.create();
    }

    public GameListPresenterComponent getGameListPresenterComponent() {
        return gameListPresenterComponent;
    }

    public GamePresenterComponent getGamePresenterComponent() {
        return gamePresenterComponent;
    }

    public ReviewPresenterComponent getReviewPresenterComponent() {
        return reviewPresenterComponent;
    }

    public PlatformListPresenterComponent getPlatformListPresenterComponent() {
        return platformListPresenterComponent;
    }
}
