package com.example.dynamic.view.edittext.edittext;

import android.content.Context;

import com.example.sg.myproject.R;


/**
 * @author sg
 * @version 1.0
 * @description 自定义一个EditText，并为其设置BACKGROUND。
 * @createDate 2015/6/29
 */
public class MyEditText1 extends CustomEditText {

    public MyEditText1(Context context) {
        super(context);
        initialize();
    }

    @Override
    void initialize() {
        setBackgroundResource(R.drawable.shape_et_background);
        setSingleLine(true);
        setPadding(0,0,0,0);
    }
}
