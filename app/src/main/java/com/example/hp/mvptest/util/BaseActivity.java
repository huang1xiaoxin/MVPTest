package com.example.hp.mvptest.util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.mvptest.base.BaseView;

/**
 * Activity都要继承该类
 * @param <V>
 * @param <P>
 */
public abstract  class BaseActivity<V extends BaseView,P extends BasePresenter<V>> extends AppCompatActivity implements IView {
    private P mPresenter;
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        if (mPresenter!=null){
            //绑定View
            mPresenter.attachView((V) this);
        }
    }

    /**
     * 加载失败的处理
     */
    @SuppressLint("ShowToast")
    @Override
    public void loadingFailed() {
        Toast.makeText(this,"加载失败",Toast.LENGTH_SHORT);
    }
    /**
     * 要求子类创建Presenter
     */
    protected abstract P createPresenter();

    public P getPresenter() {
        return mPresenter;
    }
}
