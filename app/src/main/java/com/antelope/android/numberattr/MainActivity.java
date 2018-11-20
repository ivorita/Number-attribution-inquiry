package com.antelope.android.numberattr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.antelope.android.numberattr.model.result;

import com.antelope.android.numberattr.model.Phone;
import com.antelope.android.numberattr.presenter.mainPresenter;
import com.antelope.android.numberattr.view.MainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainView {

    private EditText input_phone;
    private Button btn_search;
    private TextView result_province;
    private TextView result_type;
    private TextView result_city;
    private mainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_phone = findViewById(R.id.input_phone);
        btn_search = findViewById(R.id.btn_search);
        result_province = findViewById(R.id.result_province);
        result_type = findViewById(R.id.result_type);
        result_city = findViewById(R.id.result_city);

        btn_search.setOnClickListener(this);

        mMainPresenter = new mainPresenter(this);
        mMainPresenter.onAttach(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateView() {
        result mResult = mMainPresenter.getPhoneInfo();
        result_type.setText("运营商：" + mResult.getCompany());
        result_province.setText("省份：" + mResult.getProvince());
        result_city.setText("城市：" + mResult.getCity());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onClick(View view) {
        mMainPresenter.searchPhoneInfo(input_phone.getText().toString());
    }
}
