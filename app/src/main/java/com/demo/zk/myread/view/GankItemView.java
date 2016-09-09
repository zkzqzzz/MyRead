package com.demo.zk.myread.view;

import com.demo.zk.myread.data.GankItemData;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.view
 * Author: zk<p>.
 * time: 2016/9/9 10:19.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface GankItemView extends IBaseView {
    void onSuccess(List<GankItemData> data);
}
