package com.demo.zk.myread.model.impl;


import com.demo.zk.myread.model.IGirlItemModel;
import com.demo.zk.myread.net.NetManager;
import com.demo.zk.myread.service.GirlItemService;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model.impl
 * Author: zk<p>.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlItemModelImpl implements IGirlItemModel {
    @Override
    public Observable<String> getGirlItemData(String cid, int page) {
        GirlItemService service = NetManager.getInstance().create1(GirlItemService.class);
        return service.getGirlItemData(cid, page);
    }
}
