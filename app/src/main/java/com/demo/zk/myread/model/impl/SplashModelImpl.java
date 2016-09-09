package com.demo.zk.myread.model.impl;

import com.demo.zk.myread.data.SplashData;
import com.demo.zk.myread.model.ISplashModel;
import com.demo.zk.myread.net.NetManager;
import com.demo.zk.myread.service.SplashService;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model.impl
 * Author: zk<p>.
 * time: 2016/9/8 22:32.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class SplashModelImpl implements ISplashModel {
    @Override
    public Observable<SplashData> getSplashPic() {
        SplashService service = NetManager.getInstance().create(SplashService.class);
        return service.getSplashPic();
    }
}
