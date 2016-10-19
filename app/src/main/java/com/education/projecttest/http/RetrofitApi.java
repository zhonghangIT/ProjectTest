package com.education.projecttest.http;

import com.education.projecttest.bean.DouyuBean;
import com.education.projecttest.config.UrlConfig;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zhonghang on 2016/10/19.
 */

public interface RetrofitApi {
    @GET(UrlConfig.Path.ULR_HOT)
    Call<DouyuBean> getFace(@QueryMap() Map<String, String> params);
}
