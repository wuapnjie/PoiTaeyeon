package com.flying.xiaopo.poitaeyeon.ui.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.flying.xiaopo.poitaeyeon.R;
import com.flying.xiaopo.poitaeyeon.ui.PostcardAdapter;
import com.flying.xiaopo.poitaeyeon.ui.SwipePostcard;
import com.flying.xiaopo.poitaeyeon.ui.activities.PoscardActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public class PostcardView extends BaseView<PoscardActivity> {
    private final String TAG = PostcardView.class.getSimpleName();
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.swipe_postcard)
    SwipePostcard mSwipePostcard;
    @Bind(R.id.fab)
    FloatingActionButton mFab;


    @Override
    public int getLayoutId() {
        return R.layout.activity_postcard;
    }

    @Override
    public void init() {
        mToolbar.setTitle(R.string.app_name);
        mSwipePostcard.setOnPostcardRunOutListener(new SwipePostcard.OnPostcardRunOutListener() {
            @Override
            public void onPostcardRunOut() {
                Toast.makeText(mPresenter.getContext(), "Run out!", Toast.LENGTH_SHORT).show();
            }
        });
        mSwipePostcard.setMaxPostcardNum(4);
    }

    public void setSwipePostcardAdapter(SwipePostcard.Adapter adapter){
        mSwipePostcard.setAdapter(adapter);
    }
}
