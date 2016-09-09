package com.demo.zk.myread.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.demo.zk.myread.R;
import com.demo.zk.myread.data.SplashData;
import com.demo.zk.myread.fragment.SetFragment;
import com.demo.zk.myread.presenter.SplashPresenter;
import com.demo.zk.myread.utils.DateUtil;
import com.demo.zk.myread.utils.ImageLoader;
import com.demo.zk.myread.utils.NetUtil;
import com.demo.zk.myread.utils.SPUtil;
import com.demo.zk.myread.view.SplashView;

import butterknife.BindView;

/**
 * ClassName:com.demo.zk.myread.ui
 * Author: zk<p>.
 * time: 2016/9/8 22:18.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class SplashActivity extends BaseMvpActivity<SplashView, SplashPresenter> implements SplashView{
    private String mTimeLine;

    @BindView(R.id.splash_iv)
    ImageView mSplashIv;

    @Override
    protected SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void fetchData() {
        if (!DateUtil.formatDate().equals(mTimeLine)) {
            mPresenter.getSplashPic();
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        if (!(Boolean) SPUtil.get(SetFragment.SPLASH, false) || !NetUtil.isConnected(mContext)) {
            ImageLoader.load(mContext, R.drawable.original_splash, mSplashIv);
        } else {
            ImageLoader.load(mContext, (String) SPUtil.get("splash_url", ""), mSplashIv);
        }

        startDelay();
    }

    @Override
    protected void initData() {
        mTimeLine = (String) SPUtil.get("splash_time", "");
    }

    @Override
    public void onSuccess(SplashData data) {
        SPUtil.save("splash_time", DateUtil.formatDate());
        SPUtil.save("splash_url", data.getUrl());
    }

    @Override
    public void onError() {

    }

    private void startDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
