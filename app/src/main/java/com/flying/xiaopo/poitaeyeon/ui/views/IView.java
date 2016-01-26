package com.flying.xiaopo.poitaeyeon.ui.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flying.xiaopo.poitaeyeon.ui.activities.IPresenter;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public interface IView<P extends IPresenter> {
    void bindChildView(View root);
    int getLayoutId();
    View createRootView(LayoutInflater inflater, ViewGroup parent);
    void bindPresent(P presenter);
    void init();
}
