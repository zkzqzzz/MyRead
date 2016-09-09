package com.demo.zk.myread.adapter;

import android.app.Application;
import android.content.Context;

import com.demo.zk.myread.MyApplication;
import com.demo.zk.myread.R;
import com.demo.zk.myread.adapter.baseadapter.BaseAdapter;
import com.demo.zk.myread.adapter.baseadapter.ViewHolder;
import com.demo.zk.myread.data.GirlItemData;
import com.demo.zk.myread.utils.ImageLoader;
import com.demo.zk.myread.weiget.ScaleImageView;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.adapter
 * Author: zk<p>.
 * time: 2016/9/9 10:08.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlItemAdapter extends BaseAdapter<GirlItemData> {

    public GirlItemAdapter(Context context, List<GirlItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GirlItemData girlItemData) {
        ScaleImageView imageView = holder.getView(R.id.girl_item_iv);
        imageView.setInitSize(girlItemData.getWidth(), girlItemData.getHeight());
        ImageLoader.load( MyApplication.getContext(),
                girlItemData.getUrl(), imageView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girl_layout;
    }
}

