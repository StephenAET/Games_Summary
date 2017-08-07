package com.example.stephen.games_summary.mvp.review;

import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.mvp.MvpView;

/**
 * Created by Stephen on 07/08/2017.
 */

public interface ReviewView extends MvpView {

    void onFetchDataSuccess(RequestSingle requestSingle);
}
