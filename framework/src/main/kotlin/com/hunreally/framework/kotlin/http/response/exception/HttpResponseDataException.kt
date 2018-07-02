package com.hunreally.framework.kotlin.http.response.exception

import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.text.ParseException

/**
 * Created by Hunreally on 2018/6/28 0028.
 */

/**
 * 专门说明是服务器端处理数据结果出错
 */
class HttpResponseDataException(message: String?, cause: Throwable?) : Exception(message, cause) {}

/**
 * 全局请求错误码及错误信息实体
 */
data class ErrorCodeAndMessage(var message: String?,var errorCode:String?){}

/**
 * 全局请求错误处理
 */
class ExceptionTransformer{

    companion object {
        // 对应HTTP的状态码
        private val UNAUTHORIZED = 401
        private val FORBIDDEN = 403
        private val NOT_FOUND = 404
        private val REQUEST_TIMEOUT = 408
        private val INTERNAL_SERVER_ERROR = 500
        private val BAD_GATEWAY = 502
        private val SERVICE_UNAVAILABLE = 503
        private val GATEWAY_TIMEOUT = 504

        /**
         * 根据http请求获取简洁的错误信息
         */
        fun getErrorAndMessage(e:Throwable): ErrorCodeAndMessage {
            var errorCodeAndMessage: ErrorCodeAndMessage = ErrorCodeAndMessage(
                    "ExceptionTransformer init",
                    "ExceptionTransformer init")

            errorCodeAndMessage.message=e.message

            if (e is HttpResponseDataException){
                //服务器请求处理错误
                errorCodeAndMessage.errorCode=e.cause?.let { it.message }
            }else if (e is HttpException) {
                //网络错误
                errorCodeAndMessage.errorCode=when (e.code()) {
                    UNAUTHORIZED, FORBIDDEN, NOT_FOUND,
                    REQUEST_TIMEOUT, GATEWAY_TIMEOUT,
                    INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE
                    -> "HttpException 网络错误"
                    else -> "HttpException 网络错误"
                }
            }else if(e is JsonParseException
                    || e is JSONException
                    || e is ParseException){
                //数据解析错误
                errorCodeAndMessage.errorCode="JsonParseException"
            }else if (e is ConnectException){
                //连接错误
                errorCodeAndMessage.errorCode="ConnectException"
            }else{
                //其他类型错误
                errorCodeAndMessage.errorCode="HttpResponseDataException throw other error,place debug or log the error in this class"
            }
            return errorCodeAndMessage
        }
    }

}
