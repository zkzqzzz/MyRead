package com.demo.zk.myread.model;

import com.demo.zk.myread.data.SplashData;

import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.model
 * Author: zk<p>.
 * time: 2016/9/8 22:31.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface ISplashModel {
    Observable<SplashData> getSplashPic();
}
