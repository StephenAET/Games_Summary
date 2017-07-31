package com.example.stephen.games_summary;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.stephen.games_summary.mvp.BasePresenter;
import com.example.stephen.games_summary.mvp.MvpView;
import com.example.stephen.games_summary.mvp.gameList.GameListPresenterImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //@Mock
    //GameListPresenterImpl gameListPresenter;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.stephen.games_summary", appContext.getPackageName());
    }

    @Test
    public void basePresenter(){
        BasePresenter<MvpView> basePresenter = Mockito.mock(BasePresenter.class);
        MvpView mvpView = Mockito.mock(MvpView.class);

        basePresenter.attachView(mvpView);
        basePresenter.checkViewAttached();
        basePresenter.detachView();
    }

    @Test
    public void gameListPresenterPerformGameList(){

        GameListPresenterImpl gameListPresenter = Mockito.mock(GameListPresenterImpl.class);
        gameListPresenter.performGameList();
    }
}
