package com.antelope.android.numberattr.utils;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {

    /*private String mUrl;
    private Map<String,String> mParam;
    private HttpResponse mResponse;
    private OkHttpClient mOkHttpClient;

    public HttpUtils(HttpResponse response) {
        mResponse = response;
        mOkHttpClient = new OkHttpClient();
    }

    public interface HttpResponse{
        void onSuccess(Object object);
        void onFail(String error);
    }

    public void sendPostHttp(String url, Map<String,String> param) {
        sendHttp(url,param,true);
    }

    public void sendGetHttp(String url,Map<String,String> param) {
        sendHttp(url,param,false);
    }

    private void sendHttp(String url,Map<String,String> param,boolean isPost){
        mUrl = url;
        mParam = param;
        //编写http请求逻辑
        run(isPost);

    }

    private void run(boolean isPost){
        Request request = new Request.Builder()
                .url(mUrl)
                .build();
        mOkHttpClient.newCall(request).enqueue(c);
    }*/

    public static void sendHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
