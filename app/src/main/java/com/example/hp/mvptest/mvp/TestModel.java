package com.example.hp.mvptest.mvp;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * 因为Model在获取到数据之后，可以通过RxJava来响应，通知Presenter，所以不写接口回调
 */
public  class TestModel {
    public Observable<String> getDataModel(){
        Observable<String> observable=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("恭喜您，数据加载成功");
            }
        });
        return  observable;
    }
}
