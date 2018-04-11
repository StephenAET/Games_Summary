package com.strawdev.stephen.games_summary.mvp.review;

import com.strawdev.stephen.games_summary.model.RequestSingle;
import com.strawdev.stephen.games_summary.mvp.MvpView;

/**
 * Created by Stephen on 07/08/2017.
 */

public interface ReviewView extends MvpView {

    void onFetchDataSuccess(RequestSingle requestSingle);
}
