package com.example.hp.mvptest.util;

import com.example.hp.mvptest.base.BaseView;

/**
 * 定义一个View的接口，定义一个让Presenter更新UI的方法
 */
public interface IView extends BaseView {
    void loadingView(Object string);
}
