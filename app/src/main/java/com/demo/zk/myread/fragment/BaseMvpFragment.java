package com.demo.zk.myread.fragment;

import android.os.Bundle;

import com.demo.zk.myread.presenter.BasePresenter;

/**
 * ClassName:com.demo.zk.myread.fragment
 * Author: zk<p>.
 * time: 2016/9/9 10:06.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public abstract class BaseMvpFragment<V, P extends BasePresenter<V>> extends BaseFragment {
    protected static final String SUB_TYPE = "subtype";

    protected P mPresenter;

    protected abstract P initPresenter();

    protected abstract void fetchData();

    protected boolean mIsViewInitiated;
    protected boolean mIsVisibleToUser;
    protected boolean mIsDataInitiated;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisibleToUser = isVisibleToUser;
        initFetchData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        mIsViewInitiated = true;
        initFetchData();
    }

    protected void initFetchData() {
        if (mIsVisibleToUser && mIsViewInitiated && !mIsDataInitiated) {
            fetchData();
            mIsDataInitiated = true;
        }
    }

    @Override
    public void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }
}
