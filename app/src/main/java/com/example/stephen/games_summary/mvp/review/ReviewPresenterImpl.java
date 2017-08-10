package com.example.stephen.games_summary.mvp.review;

import android.util.Log;

import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.mvp.BasePresenter;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Stephen on 07/08/2017.
 */

public class ReviewPresenterImpl extends BasePresenter<ReviewView> implements ReviewPresenter {


    //Presenter requires an Interactor
    ReviewInteractor reviewInteractor;

    //Disposable for making Async Requests
    Disposable disposable = new CompositeDisposable();

    /**
     * Create Review Presenter
     * @param reviewInteractor The Presenter needs a Game List Interactor to perform Requests
     */
    public ReviewPresenterImpl(ReviewInteractor reviewInteractor){
        this.reviewInteractor = reviewInteractor;
    }


    @Override
    public void performReview(String id) {

        //Make sure the View is attached before attempting to do anything
        checkViewAttached();

        //Tell the View the Request has begun
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

                        //If there is a connection, attempt to perform the Request
                        if (aBoolean) {

                            Log.i("RequestArray", "Internet Connection Available, Attempting RequestArray");

                            //Perform a Disposable Request (With an Observable)
                            // Subscribe and Observe it
                            disposable = reviewInteractor.getReviewRequest(id)
                                    //Perform on new Thread
                                    .subscribeOn(Schedulers.newThread())
                                    //Observe on UI Thread
                                    .observeOn(AndroidSchedulers.mainThread())
                                    //React to Result/s
                                    .subscribe(this::success, this::onError);
                        }
                    }

                    private void onError(Throwable throwable) {
                        getView().onFetchDataError(throwable);
                    }

                    /**
                     * The view will be notified that the RequestArray Succeeded and given the Game RequestArray Data
                     * @param requestSingle The Game RequestSingle Data
                     */
                    private void success(RequestSingle requestSingle) {
                        getView().onFetchDataSuccess(requestSingle);
                        getView().onFetchDataCompleted();
                    }
                });
    }

    /**
     * Upon detaching the View, the disposable needs to be cleared
     */
    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null){
            Log.i("Disposable", "Review Disposable Disposed");
            disposable.dispose();
        }
    }
}
