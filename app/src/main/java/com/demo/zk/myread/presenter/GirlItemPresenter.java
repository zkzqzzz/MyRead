package com.demo.zk.myread.presenter;

import com.demo.zk.myread.model.IGirlItemModel;
import com.demo.zk.myread.model.impl.GirlItemModelImpl;
import com.demo.zk.myread.service.RxManager;
import com.demo.zk.myread.service.RxSubscriber;
import com.demo.zk.myread.utils.JsoupUtil;
import com.demo.zk.myread.view.GirlItemView;

/**
 * ClassName:com.demo.zk.myread.presenter
 * Author: zk<p>.
 * time: 2016/9/9 10:32.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlItemPresenter extends BasePresenter<GirlItemView> {
    private IGirlItemModel mModel;

    public GirlItemPresenter() {
        mModel = new GirlItemModelImpl();
    }

    public void getGirlItemData(String cid, int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlItemData(cid, page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirls(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}