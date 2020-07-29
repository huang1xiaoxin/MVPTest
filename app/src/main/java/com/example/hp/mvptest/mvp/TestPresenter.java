package com.example.hp.mvptest.mvp;

import com.example.hp.mvptest.util.IView;
import com.example.hp.mvptest.util.BasePresenter;

import io.reactivex.functions.Consumer;

class TestPresenter extends BasePresenter<IView> {

    private TestModel mMdodel;

    public  TestPresenter(){
        mMdodel=new TestModel();
    }
    public void getData(){
        mMdodel.getDataModel().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                getView().get().loadingView(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                getView().get().loadingView("加载失败");
            }
        });
    }
}
