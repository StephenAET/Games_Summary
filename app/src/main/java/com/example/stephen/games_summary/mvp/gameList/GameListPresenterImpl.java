package com.example.stephen.games_summary.mvp.gameList;

import com.example.stephen.games_summary.model.Request;
import com.example.stephen.games_summary.mvp.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameListPresenterImpl extends BasePresenter<GameListView> implements GameListPresenter {

    //Presenter requires an Interactor
    GameListInteractor gameListInteractor;

    //Disposable for making Async Requests
    CompositeDisposable disposable = new CompositeDisposable();

    /**
     * Create Game List Presenter
     * @param gameListInteractor The Presenter needs a Game List Interactor to perform Requests
     */
    public GameListPresenterImpl(GameListInteractor gameListInteractor){
         this.gameListInteractor = gameListInteractor;
    }



    /**
     * Perform a Disposable Game List Request
     */
    @Override
    public void performGameList(String filter) {

        //Make sure the View is attached before attempting to do anything
        checkViewAttached();

        //Tell the View the Request has begun
        getView().onFetchDataStarted();

        //Perform a Disposable Request and Subscribe to it
        disposable.add(gameListInteractor.getGameListRequest(filter)
                .subscribe(this::success, this::onError)
        );
    }

    /**
     * If the Disposable Request Fails, the view needs to know
     * @param throwable What caused the Request to Fail
     */
    private void onError(Throwable throwable) {
        getView().onFetchDataError(throwable);
    }

    /**
     * The view will be notified that the Request Succeeded and given the Game List Request Data
     * @param request The Game List Request Data
     */
    private void success(Request request) {
        getView().onFetchDataSuccess(request);
        getView().onFetchDataCompleted();
    }

    /**
     * Upon detaching the View, the disposable needs to be cleared
     */
    @Override
    public void detachView(){
        super.detachView();
        disposable.clear();
    }
}
