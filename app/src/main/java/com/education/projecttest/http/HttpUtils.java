package com.education.projecttest.http;

import com.education.projecttest.bean.DouyuBean;
import com.education.projecttest.config.UrlConfig;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhonghang on 2016/10/19.
 */

public class HttpUtils {
    //1 私有构造器
    //2 私有的静态的对象
    //3 公开的静态的方法
    private HttpUtils() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = mRetrofit.create(RetrofitApi.class);
    }

    private static HttpUtils mHttpUtils;

    public synchronized static HttpUtils newInstance() {
        if (mHttpUtils == null) {
            mHttpUtils = new HttpUtils();
        }
        return mHttpUtils;
    }

    //使用Retrofit的步骤
    //1 接口
    //2 实例化retrofit
    //3 实例化接口
    //4 使用接口调用方法
    private Retrofit mRetrofit;
    private RetrofitApi mApi;

    public void getFace(Map<String, String> params, Callback<DouyuBean> callback) {
        Call<DouyuBean> call = mApi.getFace(params);
        call.enqueue(callback);
    }

}
