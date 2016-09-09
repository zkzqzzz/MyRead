package com.demo.zk.myread.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.demo.zk.myread.fragment.BaseMvpFragment;

import java.util.List;

/**
 * ClassName:com.demo.zk.myread.adapter
 * Author: zk<p>.
 * time: 2016/9/9 10:10.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class TypePageAdapter extends FragmentPagerAdapter {
    private List<BaseMvpFragment> fragments;
    private List<String> titles;

    public TypePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<BaseMvpFragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
