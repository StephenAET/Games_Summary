package com.example.stephen.games_summary.mvp.review;

import com.example.stephen.games_summary.giantBomb.GiantBombConstants;
import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.mvp.BaseInteractor;

import io.reactivex.Observable;

/**
 * Created by Stephen on 07/08/2017.
 */

public class ReviewInteractorImpl extends BaseInteractor implements ReviewInteractor {

    @Override
    public Observable<RequestSingle> getReviewRequest(String id) {
        return getGiantBombApi().getReviewRequest(id, GiantBombConstants.API_KEY_VALUE, GiantBombConstants.JSON);
    }
}