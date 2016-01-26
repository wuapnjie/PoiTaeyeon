package com.flying.xiaopo.poitaeyeon.model;

import com.flying.xiaopo.poitaeyeon.model.apis.PoiTaeyeonService;
import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeon;
import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeons;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public class DataTruck {
    private final String TAG = DataTruck.class.getSimpleName();
    public static final String BASE_URL = "http://192.168.1.100:8080/PoiTaeyeon-service/webapi/";

    private PoiTaeyeonService mService;

    private DataTruck(PoiTaeyeonService service) {
        mService = service;
    }

    public static DataTruck trucking(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return new DataTruck(retrofit.create(PoiTaeyeonService.class));
    }

    public Call<Taeyeons> takeAllGoods(){
        return mService.listTaeyeon();
    }

    public Call<Taeyeon> takeLatestGood(){
        return mService.getLatest();
    }

    public Call<Taeyeon> takeGoodById(int id){
        return mService.getById(id);
    }

}
