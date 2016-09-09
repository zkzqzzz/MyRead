package com.demo.zk.myread.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;

import com.demo.zk.myread.data.GirlItemData;
import com.demo.zk.myread.utils.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:com.demo.zk.myread.service
 * Author: zk<p>.
 * time: 2016/9/8 22:33.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class DataService extends IntentService {
    public DataService() {
        super("");
    }

    public static void startService(Context context, List<GirlItemData> datas, String subtype) {
        Intent intent = new Intent(context, DataService.class);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) datas);
        intent.putExtra("subtype", subtype);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        List<GirlItemData> datas = intent.getParcelableArrayListExtra("data");
        String subtype = intent.getStringExtra("subtype");
        handleGirlItemData(datas, subtype);
    }

    private void handleGirlItemData(List<GirlItemData> datas, String subtype) {
        if (datas.size() == 0) {
            EventBus.getDefault().post("finish");
            return;
        }
        for (GirlItemData data : datas) {
            Bitmap bitmap = ImageLoader.load(this, data.getUrl());
            if (bitmap != null) {
                data.setWidth(bitmap.getWidth());
                data.setHeight(bitmap.getHeight());
            }

            data.setSubtype(subtype);
        }
        EventBus.getDefault().post(datas);
    }
}
