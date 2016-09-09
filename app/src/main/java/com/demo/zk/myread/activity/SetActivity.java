package com.demo.zk.myread.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.demo.zk.myread.R;
import butterknife.BindView;

/**
 * ClassName:com.demo.zk.myread.activity
 * Author: zk<p>.
 * time: 2016/9/9 9:49.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class SetActivity extends BaseActivity {
    @BindView(R.id.set_toolbar)
    Toolbar mToolbar;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
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

    @Override
    protected void initData() {

    }
}
