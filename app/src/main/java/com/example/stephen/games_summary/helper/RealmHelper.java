package com.example.stephen.games_summary.helper;

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
    public boolean saveRealmObjectToRealm(final RealmObject object) {

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
        } catch (Exception e) {
            Log.e("Realm", e.getLocalizedMessage());
            return  false;
        }
        return true;
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
        } catch (Exception e) {
            Log.e("Realm", e.getLocalizedMessage());
        }
        return results;
    }

    /**
     * Get a Realm Object from the Realm of a given RealmObject extended Class
     *
     * @param clazz Object class type that extends RealmObject
     * @return
     */
    public <T extends RealmObject> RealmObject getRealmObject(Class<T> clazz, Integer id) {
        final RealmObject[] result = {null};
        try {
            realm.executeTransaction(inRealm -> {
                final T realmObject = inRealm.where(clazz).equalTo("id", id).findFirst();
                result[0] = realmObject;
            });
        } catch (Exception e) {
            Log.i("Realm", e.getLocalizedMessage());
        }
        return result[0];
    }

    public <T extends RealmObject> boolean deleteObjectFromRealm(Class<T> clazz, Integer id) {
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    RealmResults<T> result = realm.where(clazz).equalTo("id", id).findAll();
                    result.deleteAllFromRealm();
                }
            });
        } catch (Exception e) {
            Log.e("Realm", e.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
