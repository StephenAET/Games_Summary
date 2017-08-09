package com.example.stephen.games_summary.injection.component;

import com.example.stephen.games_summary.fragment.ReviewFragment;
import com.example.stephen.games_summary.injection.module.ReviewPresenterModule;

import dagger.Component;

/**
 * Created by Stephen on 09/08/2017.
 */

@Component(dependencies = {ReviewPresenterModule.class})
public interface ReviewPresenterComponent {
    void inject(ReviewFragment target);
}
