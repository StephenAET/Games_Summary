package com.example.stephen.games_summary.mvp.review;

import com.example.stephen.games_summary.model.RequestSingle;

import io.reactivex.Observable;

/**
 * Created by Stephen on 07/08/2017.
 */

public interface ReviewInteractor {

    Observable<RequestSingle> getReviewRequest(String id);
}
