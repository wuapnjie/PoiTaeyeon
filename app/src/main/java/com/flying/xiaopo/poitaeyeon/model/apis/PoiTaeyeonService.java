package com.flying.xiaopo.poitaeyeon.model.apis;

import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeon;
import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeons;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public interface PoiTaeyeonService {
    @GET("taeyeons")
    Call<Taeyeons> listTaeyeon();

    @GET("taeyeons/taeyeon/latest")
    Call<Taeyeon> getLatest();

    @GET("taeyeons/taeyeon")
    Call<Taeyeon> getById(@Query("id") int id);
}
