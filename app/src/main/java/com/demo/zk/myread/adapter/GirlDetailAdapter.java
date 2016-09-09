package com.demo.zk.myread.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.demo.zk.myread.fragment.BaseFragment;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.adapter
 * Author: zk<p>.
 * time: 2016/9/9 10:09.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class GirlDetailAdapter extends FragmentPagerAdapter {
    public GirlDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    private List<BaseFragment> fragments;

    public void setData(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
