package com.example.stephen.games_summary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.stephen.games_summary.R;
import com.example.stephen.games_summary.model.RequestSingle;
import com.example.stephen.games_summary.mvp.review.ReviewInteractor;
import com.example.stephen.games_summary.mvp.review.ReviewInteractorImpl;
import com.example.stephen.games_summary.mvp.review.ReviewPresenter;
import com.example.stephen.games_summary.mvp.review.ReviewPresenterImpl;
import com.example.stephen.games_summary.mvp.review.ReviewView;

/**
 * Created by Stephen on 07/08/2017.
 */

public class ReviewFragment extends Fragment implements ReviewView {

    RatingBar reviewScore;

    ReviewInteractor reviewInteractor;
    ReviewPresenter reviewPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reviewScore = view.findViewById(R.id.ratingBar);

        reviewInteractor = new ReviewInteractorImpl();
        reviewPresenter = new ReviewPresenterImpl(reviewInteractor);
        reviewPresenter.attachView(this);

        int gameId = getArguments().getInt("id");
        reviewPresenter.performReview(Integer.toString(gameId));
    }

    @Override
    public void onFetchDataStarted() {

    }

    @Override
    public void onFetchDataError(Throwable e) {
        Log.e("Review", e.getLocalizedMessage());
    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onFetchDataSuccess(RequestSingle requestSingle) {
        reviewScore.setMax(5);
        reviewScore.setProgress(requestSingle.getResult().getScore());
    }
}
