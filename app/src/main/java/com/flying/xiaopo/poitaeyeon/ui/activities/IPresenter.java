package com.flying.xiaopo.poitaeyeon.ui.activities;

import com.flying.xiaopo.poitaeyeon.ui.views.IView;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public interface IPresenter<V extends IView> {
    V createView();
}
