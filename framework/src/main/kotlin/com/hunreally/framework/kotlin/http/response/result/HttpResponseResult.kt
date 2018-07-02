package com.hunreally.framework.kotlin.http.response.result

/*
 * Created by Hunreally on 2018/6/15 0012.
 */
//请求响应结果
data class HttpResponseResult<DataT>(
        var isS:Boolean,
        var resultC:String?,
        var eMsg:String?,
        var sMsg:String?,
        var resultData:DataT?
        )
{
//    //请求在服务器是否成功处理的标志
//    var isS:Boolean=false
//    //请求的返回码
//    var resultC:String?=null
//    //请求返回错误信息
//    var eMsg:String?=null
//    //请求返回成功信息
//    var sMsg:String?=null
//    //请求返回的内容数据部分
//    var resultData:DataT?=null
}