package com.example.stephen.games_summary;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Stephen on 04/08/2017.
 */

public class RealmHelper {

    Realm realm;

    /**
     * The Realm Helper requires a Realm to Operate on
     *
     * @param realm
     */
    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    /**
     * Save a Realm Object to the Realm
     *
     * @param object
     */
    public void saveRealmObjectToRealm(final RealmObject object) {
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    try {
                        realm.insertOrUpdate(object);
                    } catch (Exception e) {
                        Log.e("Realm Error", e.getLocalizedMessage());
                    }
                }
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    /**
     * Get a List of Realm Objects from the Realm of a given RealmObject extended Class
     *
     * @param clazz Object class type that extends RealmObject
     * @return
     */
    public <T extends RealmObject> List<RealmObject> getRealmObjects(Class<T> clazz) {

        List<RealmObject> results = new ArrayList<>();
        try {
            realm.executeTransaction(inRealm -> {
                final RealmResults<T> realmObjects = inRealm.where(clazz).findAll();
                results.addAll(realmObjects);
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
        return results;
    }

    /**
     * Get a Realm Object from the Realm of a given RealmObject extended Class
     *
     * @param clazz Object class type that extends RealmObject
     * @return
     */
    public <T extends RealmObject> RealmObject getRealmObject(Class<T> clazz, String id) {
        final RealmObject[] result = {null};
        try {
            realm.executeTransaction(inRealm -> {
                final T realmObject = inRealm.where(clazz).equalTo("id", id).findFirst();
                result[0] = realmObject;
            });
        } catch (Exception e){
            Log.i("Realm", e.getLocalizedMessage());
        }
        return result[0];
    }

    public <T extends RealmObject> void deleteObjectFromRealm(Class<T> clazz, int id) {
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<T> result = realm.where(clazz).equalTo("id", id).findAll();
                    result.deleteAllFromRealm();
                }
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
