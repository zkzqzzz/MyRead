package com.demo.zk.myread.presenter;

import com.demo.zk.myread.data.SplashData;
import com.demo.zk.myread.model.ISplashModel;
import com.demo.zk.myread.model.impl.SplashModelImpl;
import com.demo.zk.myread.service.RxManager;
import com.demo.zk.myread.service.RxSubscriber;
import com.demo.zk.myread.view.SplashView;

/**
 * ClassName:com.demo.zk.myread.presenter
 * Author: zk<p>.
 * time: 2016/9/8 22:28.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class SplashPresenter extends BasePresenter<SplashView> {
    private ISplashModel mModel;

    public SplashPresenter(){
        mModel = new SplashModelImpl();
    }

    public void getSplashPic() {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getSplashPic(), new RxSubscriber<SplashData>(false) {
            @Override
            protected void _onNext(SplashData data) {
                mView.onSuccess(data);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
