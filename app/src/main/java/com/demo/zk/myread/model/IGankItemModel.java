package com.demo.zk.myread.model;


import com.demo.zk.myread.data.GankItemData;
import com.demo.zk.myread.data.HttpResult;

import java.util.List;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model
 * Author: zk<p>.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface IGankItemModel {
    Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl);
}
