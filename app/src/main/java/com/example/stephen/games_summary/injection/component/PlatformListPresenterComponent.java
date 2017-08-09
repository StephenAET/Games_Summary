package com.example.stephen.games_summary.injection.component;

import com.example.stephen.games_summary.MainActivity;
import com.example.stephen.games_summary.injection.module.PlatformListPresenterModule;

import dagger.Component;

/**
 * Created by Stephen on 09/08/2017.
 */

@Component(dependencies = {PlatformListPresenterModule.class})
public interface PlatformListPresenterComponent {
    void inject(MainActivity target);
}
