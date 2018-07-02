package com.hunreally.framework.kotlin.http.converter

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type


/**
 * Created by Hunreally on 2018/6/15 0015.
 */
//字符串转换处理所需
class StringConverterFactory: Converter.Factory(){
    companion object {
        fun create(): StringConverterFactory {
            return StringConverterFactory()
        }
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return ConfigurationServiceConverter()
    }

    internal inner class ConfigurationServiceConverter : Converter<ResponseBody, String> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): String {
            val r = BufferedReader(InputStreamReader(value.byteStream()))
            val total = StringBuilder()
            var line: String?
            if (r!=null)
            {
                line = r.readLine()
                while (line != null
                        &&r!=null
                ) {
                    total.append(line)
                    line = r.readLine()
                }
            }
            return total.toString()
        }
    }
}
