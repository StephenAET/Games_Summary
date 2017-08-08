package com.example.stephen.games_summary;

import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.example.stephen.games_summary.model.RequestArray;
import com.example.stephen.games_summary.model.Result;
import com.example.stephen.games_summary.mvp.platformList.PlatformListInteractor;
import com.example.stephen.games_summary.mvp.platformList.PlatformListInteractorImpl;
import com.example.stephen.games_summary.mvp.platformList.PlatformListPresenter;
import com.example.stephen.games_summary.mvp.platformList.PlatformListPresenterImpl;
import com.example.stephen.games_summary.mvp.platformList.PlatformListView;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements PlatformListView {

    Toolbar toolbar;
    SearchView searchView;

    PlatformListPresenter platformListPresenter;

    List<Result> platforms = new ArrayList<>(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Fabric Kit for Crash Reporting
        Fabric.with(this, new Crashlytics());

        toolbar = (Toolbar) findViewById(R.id.toolbar);


        //Set the toolbar in the layout as the activities Support Action Bar
        setSupportActionBar(toolbar);

        //The Search View for making Search Requests
        searchView = (SearchView) findViewById(R.id.search_edit_frame);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search for Games");
        searchView.setIconifiedByDefault(false);//Prevent the Search bar from Collapsing
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                displaySearchResults("name",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TODO Use Realm?
                return false;
            }
        });

        PlatformListInteractor platformListInteractor = new PlatformListInteractorImpl();
        platformListPresenter = new PlatformListPresenterImpl(platformListInteractor);
        platformListPresenter.attachView(this);
        platformListPresenter.performPlatformList();
    }

    private void displaySearchResults(String header, String query){
        Bundle bundle = new Bundle();
        bundle.putString("header", header);
        bundle.putString("query", query);
        GameListFragment gameListFragment = new GameListFragment();
        gameListFragment.setArguments(bundle);
        this.getFragmentManager().beginTransaction()
                .replace(R.id.main_container, gameListFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    private void displayFavorites(){
        FavoritesFragment favoritesFragment = new FavoritesFragment();
        this.getFragmentManager().beginTransaction()
                .replace(R.id.main_container, favoritesFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    /**
     * Set the Menu for the Support Action Bar (Toolbar)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_favorites:
                displayFavorites();
                break;
            case R.id.menu_platforms:
                displayPlatformsDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFetchDataStarted() {
        //TODO
    }

    @Override
    public void onFetchDataError(Throwable e) {
        //TODO
    }

    @Override
    public void onFetchDataCompleted() {
        //TODO
    }

    @Override
    public void onFetchDataSuccess(RequestArray requestArray) {
        requestArray.getResults().forEach(result -> platforms.add(result));
    }

    private void displayPlatformsDialog(){

        List<String> platformNameList = new ArrayList<>(0);
        platforms.forEach(genre -> platformNameList.add(genre.getName()));
        String[] platformNameArray = platformNameList.toArray(new String[0]);

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle("Example");
        b.setItems(platformNameArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();


                Result genre = platforms.get(which);

                if (genre != null){
                    displaySearchResults("platforms", Integer.toString(platforms.get(which).getId()));
                }
            }
        });
        b.show();
    }
}