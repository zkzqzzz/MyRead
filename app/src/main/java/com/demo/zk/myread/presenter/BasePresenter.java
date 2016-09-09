package com.demo.zk.myread.presenter;

import rx.Subscription;

/**
 * ClassName:com.demo.zk.myread.presenter
 * Author: zk<p>.
 * time: 2016/9/8 22:23.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class BasePresenter < V >{
    public V mView;
    protected Subscription mSubscription;

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }
}
