package com.demo.zk.myread.model.impl;


import com.demo.zk.myread.model.IGirlDetailModel;
import com.demo.zk.myread.net.NetManager;
import com.demo.zk.myread.service.GirlDetailService;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model.impl
 * Author: zk<p>.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlDetailModelImpl implements IGirlDetailModel {

    @Override
    public Observable<String> getGirlDetailData(String id) {
        GirlDetailService service = NetManager.getInstance().create1(GirlDetailService.class);
        return service.getGirlDetailData(id);
    }
}
