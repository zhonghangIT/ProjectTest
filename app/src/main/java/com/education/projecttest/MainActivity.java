package com.education.projecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.education.projecttest.bean.DouyuBean;
import com.education.projecttest.bean.RoomBean;
import com.education.projecttest.config.UrlConfig;
import com.education.projecttest.http.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<RoomBean> mList;
    private MyQuickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mList = new ArrayList<>();
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new MyQuickAdapter(R.layout.item_face, mList);
        mRecyclerView.setAdapter(adapter);
        initData();

    }

    private void initData() {
        //访问网络数据
        Map<String, String> params = new HashMap<>();
        params.put(UrlConfig.Params.LIMIT, "20");
        params.put(UrlConfig.Params.OFFSET, "0");
        params.put(UrlConfig.Params.TIME, UrlConfig.DefaultValue.TIME);
        HttpUtils.newInstance().getFace(params, new Callback<DouyuBean>() {
            @Override
            public void onResponse(Call<DouyuBean> call, Response<DouyuBean> response) {
                DouyuBean douyuBean = response.body();
                List<RoomBean> roomBeenList = douyuBean.getData();
                mList.addAll(roomBeenList);
                adapter.notifyDataSetChanged();
                ((App) getApplication()).liteOrm.save(roomBeenList);
                for (RoomBean bean : roomBeenList) {
                    Log.d("MainActivity", bean.getRoomName());
                }
            }

            @Override
            public void onFailure(Call<DouyuBean> call, Throwable t) {

            }
        });
    }
}
