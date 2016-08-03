package com.example.refreshdemo.api;

import com.example.refreshdemo.bean.NewsResp;
import com.example.refreshdemo.finals.Urls;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by YANG
 * 2016/5/6 17:14
 * 请求接口
 */
public interface APIService {

    @GET("http://apis.baidu.com/txapi/keji/keji")
    @Headers("apikey:" + Urls.BaiduKey)
    Call<NewsResp> getNews(@QueryMap Map<String, String> params);

}
