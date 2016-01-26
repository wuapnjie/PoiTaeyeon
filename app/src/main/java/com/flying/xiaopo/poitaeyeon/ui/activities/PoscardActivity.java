package com.flying.xiaopo.poitaeyeon.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.flying.xiaopo.poitaeyeon.R;
import com.flying.xiaopo.poitaeyeon.model.DataTruck;
import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeons;
import com.flying.xiaopo.poitaeyeon.ui.PostcardAdapter;
import com.flying.xiaopo.poitaeyeon.ui.views.PostcardView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

public class PoscardActivity extends BaseActivity<PostcardView> {
    public static final String TAG = PoscardActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchTaeyeons();
    }

    @Override
    public PostcardView createView() {
        return new PostcardView();
    }


    public void fetchTaeyeons(){
        Call<Taeyeons> call = DataTruck.trucking(DataTruck.BASE_URL).takeAllGoods();
        call.enqueue(new Callback<Taeyeons>() {
            @Override
            public void onResponse(retrofit.Response<Taeyeons> response, Retrofit retrofit) {
//                List<Taeyeon> taeyeons = response.body().getTaeyeon();
//                for (Taeyeon taeyeon : taeyeons) {
//                    StringBuilder info = new StringBuilder();
//                    info.append("id->").append(taeyeon.getId())
//                            .append(",describe->").append(taeyeon.getDescription())
//                            .append(",date->").append(taeyeon.getDate())
//                            .append(",pic->").append(taeyeon.getPic());
//                    Log.i(TAG, "test: info->"+info);
//                }

                PostcardAdapter adapter = new PostcardAdapter(PoscardActivity.this,response.body().getTaeyeon());
                mView.setSwipePostcardAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: ->"+t.toString() );
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
