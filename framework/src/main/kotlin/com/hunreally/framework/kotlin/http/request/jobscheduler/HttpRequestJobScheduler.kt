package com.hunreally.framework.kotlin.http.request.jobscheduler

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Hunreally on 2018/6/12 0012.
 */
//单例线程切换者
object HttpRequestJobScheduler {

    /**
     * 完成线程的切换
     */
    fun <T> transformerCompose(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            observable->observable
                //切换到子线程
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                //切换到主线程
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}