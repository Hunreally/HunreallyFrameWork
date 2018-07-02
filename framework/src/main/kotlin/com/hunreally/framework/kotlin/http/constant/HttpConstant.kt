package com.hunreally.framework.kotlin.http.constant

/**
 * Created by Hunreally on 2018/6/12 0012.
 */

class HttpConstant{
    companion object {
        //访问的URL
        const  val requestURL:String = "http://10.0.2.2:8080"

        /*****************************网络请求返回错误**********************************/
        const  val HTTP_RESPONSE_EORROR_CODE:String = "Fucking Request Error"
    }
}