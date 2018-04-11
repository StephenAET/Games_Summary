package com.strawdev.stephen.games_summary;

import com.strawdev.stephen.games_summary.model.RequestArray;
import com.strawdev.stephen.games_summary.mvp.BaseInteractor;
import com.strawdev.stephen.games_summary.mvp.game.GameInteractorImpl;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListInteractorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GameListInteractorImplTest {

    @Mock
    GameInteractorImpl gameInteractor;

    @Mock
    RequestArray requestArray;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void baseInteractorGetApi(){

        BaseInteractor baseInteractor = Mockito.mock(BaseInteractor.class);
        baseInteractor.getGiantBombApi();
    }

    @Test
    public void gameListInteractorGetList(){
        GameListInteractorImpl gameListInteractor = Mockito.mock(GameListInteractorImpl.class);
        Observable<RequestArray> gameListRequestObservable = gameListInteractor.getGameListRequest("");
        Assert.assertNotEquals(gameListRequestObservable, null);
    }

    @Test
    public void gameInteractorGetList(){

        //This ID points to a game page for Dark Souls III
        //String string = "3030-49884";

        //when(gameInteractor.getGameRequest(string))
                //.thenReturn(Observable.just(requestArray));

        //Assert.assertNotEquals(null, gameInteractor.getGameRequest(string));
    }


}
