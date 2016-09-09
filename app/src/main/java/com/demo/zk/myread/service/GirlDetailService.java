package com.demo.zk.myread.service;

import com.demo.zk.myread.api.Api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.service
 * Author: zk<p>.
 * time: 2016/9/9 10:27.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface GirlDetailService {
    String BASE_URL = Api.URL_GET_GIRL;

    @GET("{id}")
    Observable<String> getGirlDetailData(@Path("id") String id);
}
