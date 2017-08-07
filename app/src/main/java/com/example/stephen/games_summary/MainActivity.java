package com.example.stephen.games_summary;

import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Fabric Kit for Crash Reporting
        Fabric.with(this, new Crashlytics());

        //The Search View for making Search Requests
        searchView = (SearchView) findViewById(R.id.search_edit_frame);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search for Games");
        searchView.setIconifiedByDefault(false);//Prevent the Search bar from Collapsing
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                displaySearchResults(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TODO Use Realm?
                return false;
            }
        });
    }

    private void displaySearchResults(String query){
        Bundle bundle = new Bundle();
        bundle.putString("query", query);
        GameListFragment gameListFragment = new GameListFragment();
        gameListFragment.setArguments(bundle);
        this.getFragmentManager().beginTransaction()
                .replace(R.id.main_container, gameListFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }
}