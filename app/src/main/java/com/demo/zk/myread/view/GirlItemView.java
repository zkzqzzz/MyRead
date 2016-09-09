package com.demo.zk.myread.view;

import com.demo.zk.myread.data.GirlItemData;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.view
 * Author: zk<p>.
 * time: 2016/9/9 10:17.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface GirlItemView extends IBaseView{
    void onSuccess(List<GirlItemData> data);
}

