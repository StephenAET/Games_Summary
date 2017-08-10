package com.example.stephen.games_summary.mvp.platformList;

import android.util.Log;

import com.example.stephen.games_summary.model.RequestArray;
import com.example.stephen.games_summary.mvp.BasePresenter;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Stephen on 08/08/2017.
 */

public class PlatformListPresenterImpl extends BasePresenter<PlatformListView> implements PlatformListPresenter {

    PlatformListInteractor platformListInteractor;

    Disposable disposable;

    public PlatformListPresenterImpl(PlatformListInteractor platformListInteractor) {
        this.platformListInteractor = platformListInteractor;
    }

    @Override
    public void performPlatformList() {

        //Make sure the View is attached before attempting to do anything
        checkViewAttached();

        //Tell the View the RequestArray has begun
        getView().onFetchDataStarted();

        //Observe the Internet Connection and Respond to it's State
        ReactiveNetwork.observeInternetConnectivity()
                //Perform this on the IO thread
                .subscribeOn(Schedulers.io())
                //Observe on UI Thread
                .observeOn(AndroidSchedulers.mainThread())
                //React to Internet Connection State (On or Off)
                .subscribe(new Consumer<Boolean>() {

                    //Handle the State of the Internet
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {

                        //If there is a connection, attempt to perform the RequestArray
                        if (aBoolean) {

                            Log.i("RequestArray", "Internet Connection Available, Attempting RequestArray");

                            //Perform a Disposable RequestArray (With an Observable)
                            // Subscribe and Observe it
                            disposable = platformListInteractor.getPlatformListRequest()
                                    //Perform on new Thread
                                    .subscribeOn(Schedulers.newThread())
                                    //Observe on UI Thread
                                    .observeOn(AndroidSchedulers.mainThread())
                                    //React to Result/s
                                    .subscribe(this::success, this::onError);
                        }
                    }

                    /**
                     * If the Disposable RequestArray Fails, the view needs to know
                     *
                     * @param throwable What caused the RequestArray to Fail
                     */
                    private void onError(Throwable throwable) {
                        if (getView() != null){
                            getView().onFetchDataError(throwable);
                        }
                    }

                    /**
                     * The view will be notified that the RequestArray Succeeded and given the Platform
                     * List RequestArray Data
                     *
                     * @param requestArray The Game List RequestArray Data
                     */
                    private void success(RequestArray requestArray) {
                        if (getView() != null){
                            getView().onFetchDataSuccess(requestArray);
                            getView().onFetchDataCompleted();
                        }
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();

        if (disposable != null) {
            Log.i("Disposable", "PlatformList Disposable Disposed");
            disposable.dispose();
        }
    }
}
