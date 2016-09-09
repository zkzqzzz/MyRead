package com.demo.zk.myread.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.demo.zk.myread.presenter.BasePresenter;

/**
 * ClassName:com.demo.zk.myread.ui.activity
 * Author: zk<p>.
 * time: 2016/9/8 22:21.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public abstract class BaseMvpActivity <V ,P extends BasePresenter<V>> extends BaseActivity{
    protected P mPresenter;

    protected abstract P initPresenter();

    protected abstract void fetchData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach((V) this);

        fetchData();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }
}
