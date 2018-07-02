package com.hunreally.framework.kotlin.http.response.result.transform


import com.hunreally.framework.java.constant.FrameWorkLog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Hunreally on 2018/6/12 0012.
 */
//请求响应结果的回掉
abstract class HttpResponseResultObserver<DataT> : Observer<DataT> {

    override fun onSubscribe(d: Disposable) {
        FrameWorkLog.l("HttpResponseResultObserver-onSubscribe")
    }

    override fun onNext(data: DataT) {
        FrameWorkLog.l("HttpResponseResultObserver-onNext")
    }

    override fun onComplete() {
        FrameWorkLog.l("HttpResponseResultObserver-onComplete")
    }

    override fun onError(e: Throwable) {
        FrameWorkLog.l("HttpResponseResultObserver-onError")
    }


    /*
     *  自定义抽象方法供子类使用
     */
    //成功获取数据
    abstract fun onSuccess(data: DataT)
    //获取数据失败
    abstract fun onFailure(errorCode:String?, message: String?)
}