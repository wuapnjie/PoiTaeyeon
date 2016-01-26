package com.flying.xiaopo.poitaeyeon.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.flying.xiaopo.poitaeyeon.ui.views.BaseView;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public abstract class BaseActivity<V extends BaseView> extends AppCompatActivity implements IPresenter<V> {
    private final String TAG = BaseActivity.class.getCanonicalName();

    V mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,TAG+"->onCreate");
        mView = createView();
        View root = mView.createRootView(getLayoutInflater(),null);
        setContentView(root);
        mView.bindChildView(root);
        mView.bindPresent(this);
        mView.init();

    }

    public Context getContext(){
        return this;
    }

    @Override
    public abstract V createView();

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG,TAG+"->onAttachedToWindow");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,TAG+"->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,TAG+"->onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,TAG+"->onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,TAG+"->onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,TAG+"->onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG,TAG+"->onSaveInstanceState");
    }
}
