package com.example.hp.mvptest.util;

import com.example.hp.mvptest.base.BaseView;
import com.example.hp.mvptest.base.IPresenter;

import java.lang.ref.WeakReference;

/**
 * Presenter的基类，提供绑定View和解绑View的方法
 * 为了防止内存泄露，通过弱引用的方式来持有View
 */
public abstract  class BasePresenter<V extends BaseView> implements IPresenter<V> {

    private WeakReference<V> view;

    @Override
    public void attachView(V viewInstance) {
        view = new WeakReference<>(viewInstance);
    }

    public WeakReference<V> getView() {
        return view;
    }

}
