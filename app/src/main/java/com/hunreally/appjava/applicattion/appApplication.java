package com.hunreally.appjava.applicattion;

import com.hunreally.framework.java.HunreallyApplication;
import com.hunreally.appkotlin.httprequestclient.OneRequestApiClient;

/**
 * Created by Hunreally on 2018/6/14 0014.
 */
public class appApplication extends HunreallyApplication {

    //项目的其中一个请求URL
    //http://182.61.58.89:8080/HunreallyGradleWeb/userInfo/123
    private static final String BaseRequestURL="http://182.61.58.89:8080/";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化retrofit请求客户端(其中一个URL对应的请求对象初始化)
        OneRequestApiClient.Companion.getInstance().init(BaseRequestURL);
    }
}
