package com.flying.xiaopo.poitaeyeon.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flying.xiaopo.poitaeyeon.BuildConfig;
import com.flying.xiaopo.poitaeyeon.R;
import com.flying.xiaopo.poitaeyeon.model.beans.Taeyeon;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Flying SnowBean on 2016/1/24.
 */
public class PostcardAdapter extends SwipePostcard.Adapter {
    private final String TAG = PostcardAdapter.class.getSimpleName();

    private Context mContext;
    private List<Taeyeon> mData;

    public PostcardAdapter(Context context,List<Taeyeon> data) {
        mContext = context;
        mData = data;
        if (BuildConfig.DEBUG){
            Picasso.with(mContext).setIndicatorsEnabled(true);
        }
    }

    public List<Taeyeon> getData() {
        return mData;
    }

    public void setData(List<Taeyeon> data) {
        mData = data;
    }



    @Override
    public View createView(ViewGroup parent) {
        return LayoutInflater.from(mContext).inflate(R.layout.item_postcard, parent, false);
    }

    @Override
    public void bindView(View view, int position) {
        Taeyeon taeyeon = mData.get(position);
        Holder holder = (Holder) view.getTag();
        if (holder==null){
            holder = new Holder(view);
            view.setTag(holder);
        }
        holder.mTvDescribe.setText(taeyeon.getDescription());
        Picasso.with(mContext).load("http://192.168.1.103:8080/PoiTaeyeon-service"+taeyeon.getPic()).into(holder.mIvTaeyeon);
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_postcard.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class Holder {
        @Bind(R.id.iv_taeyeon)
        ImageView mIvTaeyeon;
        @Bind(R.id.tv_describe)
        TextView mTvDescribe;

        Holder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
