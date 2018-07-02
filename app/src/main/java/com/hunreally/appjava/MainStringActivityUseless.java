/**
 * 该文件是用于记录转换处理流程
 */



//package com.hunreally.appjava;
//
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//
//import com.hunreally.appkotlin.httprequestclient.OneRequestApiClient;
//import com.hunreally.appkotlin.utils.LogUtil;
//import com.hunreally.framework.kotlin.http.response.result.HttpResponseResult;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableSource;
//import io.reactivex.ObservableTransformer;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.functions.Function;
//import io.reactivex.schedulers.Schedulers;
//
///**
// * Created by Hunreally on 2018/6/12 0012.
// */
//public class MainStringActivityUseless extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        getSupportActionBar().hide();
////        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
////        LifecycleProvider<Lifecycle.Event> lifecycleProvider = AndroidLifecycle.createLifecycleProvider(this);
////        OneRequestApiClient.Companion.getInstance().httpRequestApiService.getUserInfo("java")
////
////                //线程切换处理
////                .compose(HttpRequestJobScheduler.INSTANCE.<HttpResponseResult<String>>transformerCompose())
////                //生命周期绑定
////                .compose(lifecycleProvider.<HttpResponseResult<String>>bindUntilEvent(Lifecycle.Event.ON_DESTROY))
////
////
////
////                .subscribe(new Observer<HttpResponseResult<String>>() {
////                    @Override
////                    public void onSubscribe(Disposable d) {
////                        LogUtil.Companion.L("onSubscribe");
////                    }
////
////                    @Override
////                    public void onNext(HttpResponseResult<String> stringHttpResponseResult) {
////                        LogUtil.Companion.L("onNext"+stringHttpResponseResult);
////                    }
////
////                    @Override
////                    public void onError(Throwable e) {
////                        LogUtil.Companion.L("onError"+e.getMessage());
////                    }
////
////                    @Override
////                    public void onComplete() {
////                        LogUtil.Companion.L("onComplete");
////                    }
////                });
//
//
//
//        OneRequestApiClient.Companion.getInstance().httpRequestApiService.getUserInfo("java").compose(new ObservableTransformer<HttpResponseResult<String>,String>(){
//
//            @Override
//            public ObservableSource<String> apply(Observable<HttpResponseResult<String>> upstream) {
//                return upstream.subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .map(new Function<HttpResponseResult<String>, String>() {
//                            @Override
//                            public String apply(HttpResponseResult<String> stringHttpResponseResult) throws Exception {
//                                return stringHttpResponseResult.getResultData();
//                            }
//                        });
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                LogUtil.Companion.L("onNext"+s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//    }
//}
