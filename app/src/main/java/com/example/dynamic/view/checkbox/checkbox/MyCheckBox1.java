package com.example.dynamic.view.checkbox.checkbox;

import android.content.Context;

import com.example.sg.myproject.R;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class MyCheckBox1 extends CustomCheckBox {

    public MyCheckBox1(Context context) {
        super(context);
        initialize();
    }

    @Override
    void initialize() {
        setButtonDrawable(R.drawable.tab_research_checkbox);
//        setBackgroundResource(R.drawable.tab_research_checkbox);
    }
}
