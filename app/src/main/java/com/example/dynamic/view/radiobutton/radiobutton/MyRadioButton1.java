package com.example.dynamic.view.radiobutton.radiobutton;

import android.content.Context;

import com.example.sg.myproject.R;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class MyRadioButton1 extends CustomRadioButton {
    @Override
    void initialize() {
        setButtonDrawable(R.drawable.tab_research_signle);
    }

    public MyRadioButton1(Context context) {
        super(context);
        initialize();
    }
}
