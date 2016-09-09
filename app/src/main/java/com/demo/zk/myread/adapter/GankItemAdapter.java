package com.demo.zk.myread.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.demo.zk.myread.R;
import com.demo.zk.myread.adapter.baseadapter.BaseAdapter;
import com.demo.zk.myread.adapter.baseadapter.ViewHolder;
import com.demo.zk.myread.data.GankItemData;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.adapter
 * Author: zk<p>.
 * time: 2016/9/9 10:09.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GankItemAdapter extends BaseAdapter<GankItemData> {


    public GankItemAdapter(Context context, List<GankItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GankItemData gankItemData) {
        holder.setText(R.id.gank_item_desc, gankItemData.getDesc());

        String who = TextUtils.isEmpty(gankItemData.getWho()) ? "null" : gankItemData.getWho();
        holder.setText(R.id.gank_item_who, who);

        holder.setText(R.id.gank_item_publishedat, gankItemData.getPublishedAt().substring(0, 10));

        String url = gankItemData.getUrl();
        int iconId;
        if (url.contains("github")) {
            iconId = R.drawable.github;
        } else if (url.contains("jianshu")) {
            iconId = R.drawable.jianshu;
        } else if (url.contains("csdn")) {
            iconId = R.drawable.csdn;
        } else if (url.contains("miaopai")) {
            iconId = R.drawable.miaopai;
        } else if (url.contains("acfun")) {
            iconId = R.drawable.acfun;
        } else if (url.contains("bilibili")) {
            iconId = R.drawable.bilibili;
        } else if (url.contains("youku")) {
            iconId = R.drawable.youku;
        } else if (url.contains("weibo")) {
            iconId = R.drawable.weibo;
        } else if (url.contains("weixin")) {
            iconId = R.drawable.weixin;
        } else {
            iconId = R.drawable.web;
        }

        holder.setBgRes(R.id.gank_item_icon, iconId);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_gank_layout;
    }

}
