package com.demo.zk.myread.service;

import com.demo.zk.myread.api.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * ClassName:com.demo.zk.myread.service
 * Author: zk<p>.
 * time: 2016/9/9 10:28.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface GirlItemService {
    String BASE_URL = Api.URL_GET_GIRL;

    @GET("show.htm")
    Observable<String> getGirlItemData(@Query("cid") String cid, @Query("pager_offset") int pager_offset);
}
