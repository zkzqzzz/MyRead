package com.demo.zk.myread.model.impl;


import com.demo.zk.myread.data.GankItemData;
import com.demo.zk.myread.data.HttpResult;
import com.demo.zk.myread.model.IGankItemModel;
import com.demo.zk.myread.net.NetManager;
import com.demo.zk.myread.service.GankItemService;

import java.util.List;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model.impl
 * Author: zk<p>.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GankItemModelImpl implements IGankItemModel {

    @Override
    public Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl) {
        GankItemService service = NetManager.getInstance().create(GankItemService.class);
        return service.getGankItemData(suburl);
    }
}
