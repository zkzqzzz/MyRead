package com.demo.zk.myread.presenter;

import com.demo.zk.myread.model.IGirlDetailModel;
import com.demo.zk.myread.model.impl.GirlDetailModelImpl;
import com.demo.zk.myread.service.RxManager;
import com.demo.zk.myread.service.RxSubscriber;
import com.demo.zk.myread.utils.JsoupUtil;
import com.demo.zk.myread.view.GirlDetailView;

/**
 * ClassName:com.demo.zk.myread.presenter
 * Author: zk<p>.
 * time: 2016/9/9 10:31.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlDetailPresenter extends BasePresenter<GirlDetailView> {
    private IGirlDetailModel mModel;

    public GirlDetailPresenter() {
        mModel = new GirlDetailModelImpl();
    }

    public void getGirlDetailData(String id) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlDetailData(id), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirlDetail(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}

