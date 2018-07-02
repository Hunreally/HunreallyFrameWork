package com.hunreally.appkotlin.httprequestclient

import com.hunreally.appkotlin.httprequestservice.OneRequestApiService
import com.hunreally.framework.kotlin.http.request.client.RetrofitOkHttpRequestApiClient

/**
 * Created by Hunreally on 2018/6/14 0014.
 */
//单利管理
class OneRequestApiClient private constructor(): RetrofitOkHttpRequestApiClient() {

    //懒加载
    lateinit var httpRequestApiService: OneRequestApiService

    //单例的对象持有者
    private object CompanionHolder {
        val INSTANCE = OneRequestApiClient()
    }

    //单例懒加载
    companion object {
        val instance by lazy { CompanionHolder.INSTANCE }
    }

    //初始化
    fun init(requestURL:String):OneRequestApiClient{
        httpRequestApiService= init(requestURL,OneRequestApiService::class.java)
        return instance
    }

}