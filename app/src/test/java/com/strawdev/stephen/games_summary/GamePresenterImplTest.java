package com.strawdev.stephen.games_summary;

import com.strawdev.stephen.games_summary.mvp.BasePresenter;
import com.strawdev.stephen.games_summary.mvp.game.GamePresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GamePresenterImplTest {

    @Mock
    BasePresenter basePresenter; //Same as doing Mockito.mock(BasePresenter.class);

    @Mock
    GamePresenterImpl gamePresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void basePresenterGetView(){
        basePresenter.getView();
    }

    @Test
    public void gameListPresenterDetachView(){
        gamePresenter.detachView();
    }

    @Test
    public void gameListPresenterPerformRequest(){

        //This ID points to a game page for Dark Souls III
        String string = "3030-49884";
        gamePresenter.performGame(string);
    }
}
