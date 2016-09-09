package com.demo.zk.myread.adapter.baseadapter;

/**
 * ClassName:com.demo.zk.myread.adapter.baseadapter
 * Author: zk<p>.
 * time: 2016/9/9 10:11.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public interface OnItemClickListeners<T> {
    void onItemClick(ViewHolder viewHolder, T data, int position);
}
