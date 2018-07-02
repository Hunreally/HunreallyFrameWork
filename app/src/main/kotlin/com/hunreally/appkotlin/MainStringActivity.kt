package com.hunreally.appkotlin

import android.os.Bundle
import com.hunreally.appjava.R
import com.hunreally.appjava.constant.HttpResponseCode
import com.hunreally.appkotlin.bean.User
import com.hunreally.appkotlin.httprequestclient.OneRequestApiClient
import com.hunreally.appkotlin.utils.log
import com.hunreally.framework.kotlin.http.response.result.transform.HttpResponseResultObservableTransformer
import com.hunreally.framework.kotlin.http.response.result.transform.HttpResponseResultStringObserver
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by Hunreally on 2018/6/12 0012.
 */
class MainStringActivity:RxAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getSupportActionBar()!!.hide()
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        OneRequestApiClient.instance.httpRequestApiService.getUserInfo("kotlin")
                //线程切换处理
                .compose(HttpResponseResultObservableTransformer<String>(this, HttpResponseCode.RESULT_SUCCESS))
                .subscribe(object : HttpResponseResultStringObserver<User>(User::class.java){
                    override fun onSuccess(data: User?) {
                        log("success==" + data!!)
                    }

                    override fun onFailure(errorCode: String?, message: String?) {
                        log("onFailure==$errorCode::$message")
                    }
                })
    }
}