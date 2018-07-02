package com.hunreally.appjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hunreally.appjava.constant.HttpResponseCode;
import com.hunreally.appkotlin.bean.User;
import com.hunreally.appkotlin.httprequestclient.OneRequestApiClient;
import com.hunreally.appkotlin.utils.LogUtil;
import com.hunreally.framework.kotlin.http.response.result.transform.HttpResponseResultObservableTransformer;
import com.hunreally.framework.kotlin.http.response.result.transform.HttpResponseResultStringObserver;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Hunreally on 2018/6/12 0012.
 */
public class MainStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        OneRequestApiClient.Companion.getInstance().httpRequestApiService.getUserInfo("java")
                .compose(new HttpResponseResultObservableTransformer<String>(this, HttpResponseCode.RESULT_SUCCESS))
                .subscribe(new HttpResponseResultStringObserver<User>(User.class) {
                    @Override
                    public void onSuccess(@Nullable User data) {
                        LogUtil.Companion.l("success=="+data);
                    }

                    @Override
                    public void onFailure(@Nullable String errorCode, @Nullable String message) {
                        LogUtil.Companion.l("onFailure=="+errorCode+"::"+message);
                    }
                });
    }
}
