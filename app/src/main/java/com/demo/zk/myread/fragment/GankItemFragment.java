package com.demo.zk.myread.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.zk.myread.R;
import com.demo.zk.myread.activity.GankDetailActivity;
import com.demo.zk.myread.adapter.GankItemAdapter;
import com.demo.zk.myread.adapter.baseadapter.OnItemClickListeners;
import com.demo.zk.myread.adapter.baseadapter.OnLoadMoreListener;
import com.demo.zk.myread.adapter.baseadapter.ViewHolder;
import com.demo.zk.myread.data.GankItemData;
import com.demo.zk.myread.presenter.GankItemPresenter;
import com.demo.zk.myread.view.GankItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ClassName:com.demo.zk.myread.fragment
 * Author: zk<p>.
 * time: 2016/9/9 10:16.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GankItemFragment extends BaseMvpFragment<GankItemView, GankItemPresenter> implements GankItemView, SwipeRefreshLayout.OnRefreshListener {

    private int PAGE_COUNT = 1;

    private String mSubtype;
    private int mTempPageCount = 2;
    private int mLastVisibleItemPosition;

    private GankItemAdapter mGankItemAdapter;

    private boolean isLoadMore;

    @BindView(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.type_item_fab)
    FloatingActionButton mFab;

    @BindView(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @OnClick(R.id.type_item_fab)
    void onClick() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    @Override
    protected GankItemPresenter initPresenter() {
        return new GankItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGankItemData("data/" + mSubtype + "/10/" + PAGE_COUNT);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_item_layout;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        mGankItemAdapter = new GankItemAdapter(mActivity, new ArrayList<GankItemData>(), true);
        mGankItemAdapter.setLoadingView(R.layout.load_loading_layout);
        mGankItemAdapter.setOnItemClickListener(new OnItemClickListeners<GankItemData>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, GankItemData gankItemData, int position) {
                Intent intent = new Intent(mActivity, GankDetailActivity.class);
                intent.putExtra("gank_item_data", gankItemData);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                        viewHolder.getView(R.id.gank_item_icon), "shareView");
                ActivityCompat.startActivity(mActivity, intent, optionsCompat.toBundle());
            }
        });

        mGankItemAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
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

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mGankItemAdapter);

        //RecyclerView滚动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (mLastVisibleItemPosition < layoutManager.findLastVisibleItemPosition() && mLastVisibleItemPosition == 12) {
                    mFab.show();
                }

                if (mLastVisibleItemPosition > layoutManager.findLastVisibleItemPosition() && mFab.isShown()) {
                    mFab.hide();
                }

                mLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    protected void initData() {
        if (getArguments() == null) {
            return;
        }
        mSubtype = getArguments().getString(SUB_TYPE);
    }

    @Override
    public void onSuccess(List<GankItemData> data) {
        if (isLoadMore) {
            if (data.size() == 0) {
                mGankItemAdapter.setLoadEndView(R.layout.load_end_layout);
            } else {
                mGankItemAdapter.setLoadMoreData(data);
                mTempPageCount++;
            }
        } else {
            mGankItemAdapter.setNewData(data);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError() {
        if (isLoadMore) {
            mGankItemAdapter.setLoadFailedView(R.layout.load_failed_layout);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    public static GankItemFragment newInstance(String subtype) {
        GankItemFragment fragment = new GankItemFragment();
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
}

