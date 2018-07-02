package com.hunreally.framework.kotlin.http.response.result.transform

import android.arch.lifecycle.Lifecycle
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.hunreally.framework.java.constant.FrameWorkLog
import com.hunreally.framework.kotlin.http.request.jobscheduler.HttpRequestJobScheduler
import com.hunreally.framework.kotlin.http.response.exception.HttpResponseDataException
import com.hunreally.framework.kotlin.http.response.result.HttpResponseResult
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * Created by Hunreally on 2018/6/28 0028.
 * 将请求回来的HttpResponseResult<DataT>类型数据转换成DataT数据类型
 */
/**
 * context:activity上下文
 */

 class  HttpResponseResultObservableTransformer <DataT>
        constructor(val context:Context,val successCode:String):
        ObservableTransformer<HttpResponseResult<DataT>,DataT>{

    override fun apply(upstream: Observable<HttpResponseResult<DataT>>): ObservableSource<DataT> {
        //绑定activity的生命周期
        var lifecycleProvider: LifecycleProvider<Lifecycle.Event>?=null
        if (context is AppCompatActivity && context!=null) {
            lifecycleProvider = AndroidLifecycle.createLifecycleProvider(this.context);
        }
        if (lifecycleProvider!=null){
            upstream.compose(lifecycleProvider.bindUntilEvent(Lifecycle.Event.ON_DESTROY))
        }
        return upstream
                //线程切换
                .compose(HttpRequestJobScheduler.transformerCompose())
                //重构返回数据类型
                .map{ httpResponseResultDataT ->
                    FrameWorkLog.l(httpResponseResultDataT.toString())
                    //判断成功码等标志
                    if (httpResponseResultDataT.isS
                            &&httpResponseResultDataT.resultC!!.isNotEmpty()
                            &&httpResponseResultDataT.resultC.equals(successCode)){
                        //如果请求在服务器端数据处理成功
                        httpResponseResultDataT.resultData
                    }else{
                        //如果请求在服务器端数据处理发生错误，处理服务器返回的错误码
                        throw HttpResponseDataException(httpResponseResultDataT.eMsg, Throwable(httpResponseResultDataT.resultC))
                    }
                }
    }

}