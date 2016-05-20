package com.example.dynamic.view.edittext.edittext;

import android.content.Context;
import android.widget.EditText;

/**
 * @author sg
 * @version 1.0
 * @description 自定义EditText的抽象类，由子类对其进行封装
 * @createDate 2015/6/29
 */
public abstract class CustomEditText extends EditText {

    public Context context;

    public CustomEditText(Context context) {
        super(context);
        this.context = context;
    }

    abstract void initialize();
}
