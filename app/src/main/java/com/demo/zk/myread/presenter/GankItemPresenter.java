package com.demo.zk.myread.presenter;

import com.demo.zk.myread.data.GankItemData;
import com.demo.zk.myread.model.IGankItemModel;
import com.demo.zk.myread.model.impl.GankItemModelImpl;
import com.demo.zk.myread.service.RxManager;
import com.demo.zk.myread.service.RxSubscriber;
import com.demo.zk.myread.view.GankItemView;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.presenter
 * Author: zk<p>.
 * time: 2016/9/9 10:31.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GankItemPresenter extends BasePresenter<GankItemView> {
    private IGankItemModel mModel;

    public GankItemPresenter() {
        mModel = new GankItemModelImpl();
    }

    public void getGankItemData(String suburl) {
        mSubscription = RxManager.getInstance().doSubscribe1(mModel.getGankItemData(suburl), new RxSubscriber<List<GankItemData>>(true) {
            @Override
            protected void _onNext(List<GankItemData> gankItemData) {
                mView.onSuccess(gankItemData);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}

