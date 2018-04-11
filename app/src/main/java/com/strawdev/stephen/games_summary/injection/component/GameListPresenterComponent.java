package com.strawdev.stephen.games_summary.injection.component;

import com.strawdev.stephen.games_summary.fragment.GameListFragment;
import com.strawdev.stephen.games_summary.injection.module.GameListPresenterModule;

import dagger.Component;

/**
 * Created by Stephen on 09/08/2017.
 */

/**
 * Component that injects the Presenter Module (that provides necessary Interactor Object)
 * into the Fragment
 */

@Component(dependencies = {GameListPresenterModule.class})
public interface GameListPresenterComponent {
    void inject(GameListFragment target);
}
