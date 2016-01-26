package com.flying.xiaopo.poitaeyeon.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flying.xiaopo.poitaeyeon.ui.activities.BaseActivity;
import com.flying.xiaopo.poitaeyeon.ui.activities.IPresenter;

import butterknife.ButterKnife;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public abstract class BaseView<P extends BaseActivity> implements IView<P>{
    private final String TAG = BaseView.class.getSimpleName();
    P mPresenter;

    @Override
    public void bindChildView(View root) {
        ButterKnife.bind(this,root);
    }


    @Override
    public abstract int getLayoutId();

    @Override
    public View createRootView(LayoutInflater inflater, ViewGroup parent) {
        View rootView = inflater.inflate(getLayoutId(),parent,false);
        return rootView;
    }

    @Override
    public void bindPresent(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public abstract void init();
}
