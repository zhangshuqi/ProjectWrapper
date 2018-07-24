package com.south.prefee.widget.retrofithelper.rxschedulers;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class RxSchedulersHelper {
    private static final ObservableTransformer ioTransformer = new ObservableTransformer() {

        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io());
        }
    };

    public static ObservableTransformer applyIoTransformer() {
        return ioTransformer;
    }
}
