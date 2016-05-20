package com.example.dynamic.view.linear;

import android.content.Context;

import com.example.dynamic.view.param.LinearParams;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class MyLinearLayout1 extends CustomLinearLayout {
    @Override
    void initialize() {
        setLayoutParams(LinearParams.getMMParams());
        setOrientation(HORIZONTAL);
    }

    public MyLinearLayout1(Context context) {
        super(context);
    }
}
