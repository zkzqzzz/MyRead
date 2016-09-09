package com.demo.zk.myread.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.demo.zk.myread.R;
import com.demo.zk.myread.adapter.GirlDetailAdapter;
import com.demo.zk.myread.data.GirlItemData;
import com.demo.zk.myread.fragment.BaseFragment;
import com.demo.zk.myread.fragment.GirlDetailFragment;
import com.demo.zk.myread.presenter.GirlDetailPresenter;
import com.demo.zk.myread.view.GirlDetailView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ClassName:com.demo.zk.myread.activity
 * Author: zk<p>.
 * time: 2016/9/9 10:22.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlDetailActivity extends BaseMvpActivity<GirlDetailView, GirlDetailPresenter> implements GirlDetailView {
    private GirlItemData mGirlItemData;

    @BindView(R.id.girl_detail_viewpager)
    ViewPager mViewPager;

    @BindView(R.id.girl_detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.girl_detail_loading)
    AVLoadingIndicatorView mLoading;

    @Override
    protected GirlDetailPresenter initPresenter() {
        return new GirlDetailPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGirlDetailData(mGirlItemData.getId());
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_girl_detail;
    }

    @Override
    protected void initView() {
        initToolbar();
    }

    @Override
    protected void initData() {
        mGirlItemData = getIntent().getParcelableExtra("girl_item_data");
    }

    @Override
    public void onSuccess(List<String> data) {
        List<BaseFragment> fragments = new ArrayList<>();
        for (String url : data) {
            fragments.add(GirlDetailFragment.newInstance(url));
        }

        GirlDetailAdapter adapter = new GirlDetailAdapter(getSupportFragmentManager());
        adapter.setData(fragments);
        mViewPager.setOffscreenPageLimit(data.size());
        mViewPager.setAdapter(adapter);

        mLoading.hide();
    }

    @Override
    public void onError() {

    }

    private void initToolbar() {
        //setTitle方法要在setSupportActionBar(toolbar)之前调用，否则不起作用
        String title = mGirlItemData.getTitle();
        title = title.length() > 10 ? title.substring(0, 10) + "..." : title;
        mToolbar.setTitle(title);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

