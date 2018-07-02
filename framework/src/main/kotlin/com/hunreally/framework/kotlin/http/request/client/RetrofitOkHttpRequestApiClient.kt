package com.hunreally.framework.kotlin.http.request.client

import com.hunreally.framework.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Hunreally on 2018/6/12 0012.
 */
open class RetrofitOkHttpRequestApiClient {

    //内部初始化，在Application的onCreate中调用一次即可
    fun <T> init(requestURL:String, clazz:Class<T>):T {
        //初始化okhttpclient
        val okHttpClient:OkHttpClient = OkHttpClient().newBuilder()
                //设置okhttp日志处理
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG)
                            HttpLoggingInterceptor.Level.BODY
                        else
                            HttpLoggingInterceptor.Level.NONE
                ))
                .build()

        //构建retrofit，绑定URL与okhttpclient
        val retrofit:Retrofit = Retrofit.Builder()
                .baseUrl(requestURL)
//                 如果后台返回的整个都是String的时候才能开启这个，并且开启这个需要自己获取字符串后进行自己的json解析
//                .addConverterFactory(StringConverterFactory.create())
                //添加json格式数据转换器,需保证服务器返回的结果如果要转为String不能以{开头
                .addConverterFactory(GsonConverterFactory.create())
                //添加RxJava适配器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        //构建请求的接口使用者
        return retrofit.create(clazz)
    }

}