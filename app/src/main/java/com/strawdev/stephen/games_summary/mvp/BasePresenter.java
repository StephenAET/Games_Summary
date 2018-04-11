package com.strawdev.stephen.games_summary.mvp;

/**
 * Created by Stephen on 31/07/2017.
 */

import com.strawdev.stephen.games_summary.fun.SillyConstants;

/**
 * Base Presenter handles most of the boilerplate associated with managing MVP managed Views
 * @param <T>
 */
public class BasePresenter <T extends MvpView> implements MvpPresenter<T> {

    private T view;

    /**
     * @return Get the View attached to this presenter
     */
    public T getView() {
        return view;
    }

    /**
     * @param mvpView The view to be attached to this presenter
     */
    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    /**
     * Exception Handling for Missing View
     */
    public void checkViewAttached(){
        if (!isViewAttached()) {
            throw new MvpViewNotAttachedException();
        }
    }

    /**
     * @return Is a View Attached to this Presenter?
     */
    private boolean isViewAttached() {
        return view != null;
    }

    /**
     * Detach the view from the presenter (if it has one)
     */
    @Override
    public void detachView() {
        view = null;
    }

    /**
     * Used for throwing an exception when a view is null
     */
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Hey pal, Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter! "+ SillyConstants.TABLE_FLIP);
        }
    }
}
