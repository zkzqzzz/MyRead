package com.demo.zk.myread.service;

import com.demo.zk.myread.api.Api;
import com.demo.zk.myread.data.GankItemData;
import com.demo.zk.myread.data.HttpResult;

import java.util.List;

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
public interface GankItemService {
    String BASE_URL = Api.URL_GET_GANK;

    @GET("{suburl}")
    Observable<HttpResult<List<GankItemData>>> getGankItemData(@Path("suburl") String suburl);
}
