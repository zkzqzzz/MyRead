package com.demo.zk.myread;

import android.app.Application;
import android.content.Context;

import com.demo.zk.myread.utils.SPUtil;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * ClassName:com.demo.zk.myread
 * Author: zk<p>.
 * time: 2016/9/8 22:13.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class MyApplication extends Application {

    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        CrashReport.initCrashReport(mContext,"900047361",false);//腾讯的
        initRealm();
        SPUtil.init(mContext, "myread");
    }
    public static Context getContext() {
        return mContext;
    }

    private void initRealm() {
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
//        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
