package com.demo.zk.myread.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.demo.zk.myread.R;
import com.demo.zk.myread.activity.GirlDetailActivity;
import com.demo.zk.myread.adapter.GirlItemAdapter;
import com.demo.zk.myread.adapter.baseadapter.OnItemClickListeners;
import com.demo.zk.myread.adapter.baseadapter.OnLoadMoreListener;
import com.demo.zk.myread.adapter.baseadapter.ViewHolder;
import com.demo.zk.myread.data.GirlItemData;
import com.demo.zk.myread.presenter.GirlItemPresenter;
import com.demo.zk.myread.service.DataService;
import com.demo.zk.myread.view.GirlItemView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ClassName:com.demo.zk.myread.fragment
 * Author: zk<p>.
 * time: 2016/9/9 10:16.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlItemFragment extends BaseMvpFragment<GirlItemView, GirlItemPresenter> implements GirlItemView, SwipeRefreshLayout.OnRefreshListener {
    private int PAGE_COUNT = 1;
    private String mSubtype;
    private int mTempPageCount = 2;

    private GirlItemAdapter mGirlItemAdapter;

    private boolean isLoadMore;//是否是底部加载更多

    @BindView(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected GirlItemPresenter initPresenter() {
        return new GirlItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGirlItemData(mSubtype, PAGE_COUNT);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_item_layout;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        mGirlItemAdapter = new GirlItemAdapter(mActivity, new ArrayList<GirlItemData>(), true);
        mGirlItemAdapter.setLoadingView(R.layout.load_loading_layout);
        mGirlItemAdapter.setOnItemClickListener(new OnItemClickListeners<GirlItemData>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, GirlItemData girlItemData, int position) {
                Intent intent = new Intent(mActivity, GirlDetailActivity.class);
                intent.putExtra("girl_item_data", girlItemData);
                startActivity(intent);
            }
        });

        mGirlItemAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                if (PAGE_COUNT == mTempPageCount && !isReload) {
                    return;
                }
                isLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        });

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//可防止Item切换
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mGirlItemAdapter);
    }

    @Override
    protected void initData() {
        if (getArguments() == null) {
            return;
        }
        mSubtype = getArguments().getString(SUB_TYPE);
    }

    @Override
    public void onSuccess(List<GirlItemData> data) {
        DataService.startService(mActivity, data, mSubtype);
    }

    @Override
    public void onError() {
        if (isLoadMore) {
            mGirlItemAdapter.setLoadFailedView(R.layout.load_failed_layout);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    public static GirlItemFragment newInstance(String subtype) {
        GirlItemFragment fragment = new GirlItemFragment();
        Bundle arguments = new Bundle();
        arguments.putString(SUB_TYPE, subtype);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onRefresh() {
        isLoadMore = false;
        PAGE_COUNT = 1;
        fetchData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataEvent(List<GirlItemData> data) {
        if (!data.get(0).getSubtype().equals(mSubtype)) {
            return;
        }

        if (isLoadMore) {
            if (data.size() == 0) {
                mGirlItemAdapter.setLoadEndView(R.layout.load_end_layout);
            } else {
                mTempPageCount++;
                mGirlItemAdapter.setLoadMoreData(data);
            }
        } else {
            mGirlItemAdapter.setNewData(data);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}