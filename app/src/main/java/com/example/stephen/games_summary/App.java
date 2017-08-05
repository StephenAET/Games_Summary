package com.example.stephen.games_summary;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Stephen on 04/08/2017.
 */

public class App extends Application {

    public void onCreate(){
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
    }
}
