package com.antelope.android.numberattr.presenter;

import android.util.Log;

import com.antelope.android.numberattr.model.Phone;
import com.antelope.android.numberattr.utils.HttpUtils;
import com.antelope.android.numberattr.view.MainView;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.antelope.android.numberattr.model.result;

public class mainPresenter extends BasePresenter{

    private Phone mPhone;

    private result mResult;

    String url = "http://apis.juhe.cn/mobile/get?phone=";

    private MainView mMainView;

    public mainPresenter(MainView mainView) {
        mMainView = mainView;
    }

    public void searchPhoneInfo(String phone){
        if (phone.length() != 11){
            mMainView.showToast("请输入正确的手机号码");
        }
        mMainView.showLoading();

        //写http请求的处理逻辑
        sendHttp(phone);
    }

    private void sendHttp(String phone) {
        HttpUtils.sendHttpRequest(url + phone
                + "&key=3bd551a06ccd36865ab436d726f74fc0", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //mMainView.showToast(e.toString());
                mMainView.hideLoading();
                Log.e("mainPresenter:", "error:" + e.toString() );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                Log.d("mainPresenter:", "responseText:" + responseText);
                mResult = parseModelWithGson(responseText);
                mMainView.hideLoading();
                mMainView.updateView();
            }
        });
    }

    private result parseModelWithGson(String response){

        Gson gson = new Gson();
        Phone phone = gson.fromJson(response,Phone.class);
        result mResult = phone.getResult();

        return mResult;
    }

    public result getPhoneInfo(){
        return mResult;
    }
}
