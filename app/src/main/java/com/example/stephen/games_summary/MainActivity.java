package com.example.stephen.games_summary;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;
import com.example.stephen.games_summary.model.Result;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    static FragmentManager fragmentManager;

    EditText searchText;
    Button searchButton;

    GameListFragment gameListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Fabric Kit
        Fabric.with(this, new Crashlytics());

        searchText = (EditText) findViewById(R.id.tv_search_value);
        searchButton = (Button) findViewById(R.id.bt_search_button);

        gameListFragment = new GameListFragment();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameListFragment.performSearch(searchText.getText().toString());
            }
        });

        fragmentManager = getFragmentManager();
        changeDisplayedFragment(gameListFragment);
    }

    public static void changeDisplayedFragment(Fragment fragment) {

        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
        }
    }

    public static void doTheThing(Result result){

        Bundle bundle = new Bundle();
        bundle.putInt("id", result.getId());

        Fragment gameFragment = new GameFragment();
        gameFragment.setArguments(bundle);

        changeDisplayedFragment(gameFragment);
    }
}