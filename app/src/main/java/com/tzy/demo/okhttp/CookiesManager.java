package com.tzy.demo.okhttp;

/**
 * Created by YANG
 * 2016/5/11 17:16
 */

import com.tzy.demo.application.MyApp;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.List;

/**
 * 自动管理Cookies
 */
public class CookiesManager implements CookieJar {
    public static final PersistentCookieStore cookieStore = new PersistentCookieStore(MyApp.getInstance().mContext);

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }
}
