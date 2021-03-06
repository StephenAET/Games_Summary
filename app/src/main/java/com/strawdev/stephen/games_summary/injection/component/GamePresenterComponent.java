package com.strawdev.stephen.games_summary.injection.component;

import com.strawdev.stephen.games_summary.fragment.GameFragment;
import com.strawdev.stephen.games_summary.injection.module.GamePresenterModule;

import dagger.Component;

/**
 * Created by Stephen on 09/08/2017.
 */

@Component(dependencies = {GamePresenterModule.class})
public interface GamePresenterComponent {
    void inject(GameFragment target);
}