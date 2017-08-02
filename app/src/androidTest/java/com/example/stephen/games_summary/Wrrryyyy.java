package com.example.stephen.games_summary;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.stephen.games_summary.mvp.gameList.GameListPresenterImpl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Stephen on 01/08/2017.
 */

@RunWith(AndroidJUnit4.class)
public class Wrrryyyy {

    private GameListPresenterImpl gameListPresenter;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class,true);

    private static final String A_URL = "A_URL";

    @Before
    public void setUp(){



    }

    @Test
    public void viewDoesAThing(){
        onView(withId(R.id.img_bookmark))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
    }



}
