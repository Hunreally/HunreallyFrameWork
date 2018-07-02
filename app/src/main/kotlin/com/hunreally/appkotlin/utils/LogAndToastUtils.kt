package com.hunreally.appkotlin.utils

import android.content.Context
import android.widget.Toast
import com.hunreally.framework.java.constant.FrameWorkLog

/**
 * Created by Hunreally on 2018/6/28 0028.
 */


/**
 * 扩展Context使用log函数
 */
fun Context.log(message:String){
        FrameWorkLog.L("LogUtil",message)
}

/**
 * 扩展Context使用toast函数
 */
fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

/**
 * 扩展Context使用toast函数
 */
fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}






/**
 * java类中的log日志类
 */
class LogUtil{

    companion object {

        fun l(message:String){
            FrameWorkLog.L("LogUtil",message)
        }

        fun L(message:String){
            FrameWorkLog.L("LogUtil",message)
        }
    }
}

/**
 * java类中的Toast类
 */
class ToastUtil{
    companion object {

        fun toast(context:Context,message: CharSequence){
            Toast.makeText(context, message,  Toast.LENGTH_SHORT).show()
        }
    }
}