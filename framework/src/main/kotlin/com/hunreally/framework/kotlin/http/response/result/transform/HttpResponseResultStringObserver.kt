package com.hunreally.framework.kotlin.http.response.result.transform


import com.google.gson.Gson
import com.hunreally.framework.java.constant.FrameWorkLog
import com.hunreally.framework.kotlin.http.response.exception.ErrorCodeAndMessage
import com.hunreally.framework.kotlin.http.response.exception.ExceptionTransformer
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by Hunreally on 2018/6/12 0012.
 */
//请求响应结果的回掉
abstract class HttpResponseResultStringObserver<DataT>
        constructor(val dataClazz:Class<DataT>): Observer<String> {

    override fun onSubscribe(d: Disposable) {
        FrameWorkLog.l("HttpResponseResultObserver-onSubscribe")
    }

    override fun  onNext(data: String) {
        FrameWorkLog.l("HttpResponseResultObserver-onNext")
        if (data.isNotEmpty()){
            //转换数据对象
            try {
                val gson: Gson = Gson()
                onSuccess(gson.fromJson(data,dataClazz))
            }catch (e:Exception){
                onError(e)
            }
        }else{
            onSuccess(null)
        }
    }

    override fun onComplete() {
        FrameWorkLog.l("HttpResponseResultObserver-onComplete")
    }

    override fun onError(e: Throwable) {
        FrameWorkLog.l("HttpResponseResultObserver-onError")
        var exceptionTransformer: ErrorCodeAndMessage = ExceptionTransformer.getErrorAndMessage(e)
        onFailure(exceptionTransformer.errorCode,exceptionTransformer.message)
    }


    /*
     *  自定义抽象方法供子类使用
     */
    //成功获取数据
    abstract fun onSuccess(data: DataT?)
    //获取数据失败
    abstract fun onFailure(errorCode:String?, message: String?)
}