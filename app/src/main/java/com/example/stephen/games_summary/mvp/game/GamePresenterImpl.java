package com.example.stephen.games_summary.mvp.game;

import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GamePresenterImpl extends BasePresenter<GameView> implements GamePresenter {

    //Presenter requires an Interactor
    GameInteractor gameInteractor;

    //Disposable for making Async Requests
    CompositeDisposable disposable = new CompositeDisposable();

    /**
     * Create Game List Presenter
     * @param gameInteractor The Presenter needs a Game List Interactor to perform Requests
     */
    public GamePresenterImpl(GameInteractor gameInteractor){
        this.gameInteractor = gameInteractor;
    }

    /**
     * Perform a Disposable Game List Request
     */
    @Override
    public void performGame(String id) {

        //Make sure the View is attached before attempting to do anything
        checkViewAttached();

        //Tell the View the Request has begun
        getView().onFetchDataStarted();

        //Perform a Disposable Request and Subscribe to it
        disposable.add(gameInteractor.getGameRequest(id)
                .subscribe(this::onSuccess, this::onError));
    }

    /**
     * If the Disposable Request Fails, the view needs to know
     * @param throwable What caused the Request to Fail
     */
    private void onError(Throwable throwable) {
        getView().onFetchDataError(throwable);
    }

    /**
     * The view will be notified that the Request Succeeded and given the Game Request Data
     * @param request The Game Request Data
     */
    private void onSuccess(Request request) {
        getView().onFetchDataSuccess(request);
        getView().onFetchDataCompleted();
    }

    /**
     * Upon detaching the View, the disposable needs to be cleared
     */
    @Override
    public void detachView() {
        super.detachView();
        disposable.clear();
    }
}
