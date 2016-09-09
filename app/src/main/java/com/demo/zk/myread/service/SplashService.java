package com.demo.zk.myread.service;

import com.demo.zk.myread.api.Api;
import com.demo.zk.myread.data.SplashData;

import retrofit2.http.GET;
import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.service
 * Author: zk<p>.
 * time: 2016/9/8 22:36.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface SplashService {
    String BASE_URL = Api.URL_GET_SPLASH_PIC;

    @GET("1080*1920")
    Observable<SplashData> getSplashPic();
}
