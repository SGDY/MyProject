package com.example.dynamic.view.edittext.edittext;

import android.content.Context;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class MyEditText2 extends CustomEditText {

    public MyEditText2(Context context) {
        super(context);
        initialize();
    }

    @Override
    void initialize() {
        setPadding(0,0,0,5);
    }
}
