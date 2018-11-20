package com.antelope.android.numberattr.presenter;

import android.content.Context;

public class BasePresenter {

    private Context mContext;

    public void onAttach(Context context){
        mContext = context;
    }

    public void onPause(){ }

    public void onResume(){}

    public void onDestroy(){
        mContext = null;
    }

}
