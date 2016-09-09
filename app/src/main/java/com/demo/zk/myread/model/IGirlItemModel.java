package com.demo.zk.myread.model;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model
 * Author: zk<p>.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IGirlItemModel {
    Observable<String> getGirlItemData(String cid, int page);
}
