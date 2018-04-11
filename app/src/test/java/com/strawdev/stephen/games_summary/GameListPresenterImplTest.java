package com.strawdev.stephen.games_summary;

import com.strawdev.stephen.games_summary.mvp.BasePresenter;
import com.strawdev.stephen.games_summary.mvp.gameList.GameListPresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Stephen on 01/08/2017.
 */

public class GameListPresenterImplTest {

    @Mock
    BasePresenter basePresenter; //Same as doing Mockito.mock(BasePresenter.class);

    @Mock
    GameListPresenterImpl gameListPresenter;

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
        gameListPresenter.detachView();
    }

    @Test
    public void gameListPresenterPerformRequest(){
        gameListPresenter.performGameList("");
    }
}
