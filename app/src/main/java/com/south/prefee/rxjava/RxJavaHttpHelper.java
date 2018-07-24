package com.south.prefee.rxjava;

import com.orhanobut.logger.Logger;
import com.south.prefee.bean.BaseRequestData;
import com.south.prefee.widget.retrofithelper.rxexception.NetworkConnectionException;
import com.south.prefee.widget.retrofithelper.rxexception.ServerException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class RxJavaHttpHelper {
    // 将访问网络成功拿到的observable对象预处理通过compose方法进行转换
    public static <T> ObservableTransformer<BaseRequestData<T>, T> handleResult() {
        ObservableTransformer<BaseRequestData<T>, T> tTransformer = new ObservableTransformer<BaseRequestData<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseRequestData<T>> upstream) {
                Logger.v(Thread.currentThread().getName() + "RxJavaHttpHelper");
                final Observable<T> observable = upstream.flatMap(new Function<BaseRequestData<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseRequestData<T> tBaseRequestData) throws Exception {
                        Logger.v(Thread.currentThread().getName() + "RxJavaHttpHelper");
                        if (tBaseRequestData == null) {
                            return Observable.error(new NetworkConnectionException(""));
                        } else if (tBaseRequestData.resultcode == 1000) {
                            //创建一个观察者
                            if (tBaseRequestData == null) {
                                tBaseRequestData = new BaseRequestData();
                            }

                            return createObservable(tBaseRequestData.datas);
                        } else {
                            return Observable.error(new ServerException(tBaseRequestData.resultcode, String.valueOf(tBaseRequestData.errormsg)));
                        }
                    }
                });
                observable.subscribeOn(io.reactivex.schedulers.Schedulers.io());
                return observable;
            }
        };
        return tTransformer;
    }

    private static <T> Observable<T> createObservable(final T data) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(data);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

}
