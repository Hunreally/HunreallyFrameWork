package com.hunreally.appkotlin.httprequestservice

import com.hunreally.framework.kotlin.http.response.result.HttpResponseResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Hunreally on 2018/6/14 0014.
 */
interface OneRequestApiService{

    /**
     * 测试使用
     */
    //GET请求
    @GET("HunreallyGradleWeb/userInfo/{userId}")
    //每个方法的返回值即一个Observable
    fun  getUserInfo(@Path("userId") user: String): Observable<HttpResponseResult<String>>


}