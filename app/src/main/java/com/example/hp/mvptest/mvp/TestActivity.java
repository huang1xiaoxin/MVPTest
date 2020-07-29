package com.example.hp.mvptest.mvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.hp.mvptest.util.BaseActivity;
import com.example.hp.mvptest.util.IView;
import com.example.hp.mvptest.R;


@SuppressLint("Registered")
public class TestActivity extends BaseActivity<IView, TestPresenter> implements View.OnClickListener {
    Button button;
    TextView textView;
    private TestPresenter mTestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_layout);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        mTestPresenter = getPresenter();
        button.setOnClickListener(this);
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
    }

    @Override
    public void loadingView(Object string) {
        textView.setText((String)string);
    }

    @Override
    public void onClick(View v) {
        if ((v.getId())==R.id.button){
            mTestPresenter.getData();
        }

    }
}
