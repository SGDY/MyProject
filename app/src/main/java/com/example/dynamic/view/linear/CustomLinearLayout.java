package com.example.dynamic.view.linear;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class CustomLinearLayout extends LinearLayout {

    public Context context;

    public CustomLinearLayout(Context context) {
        super(context);
        this.context = context;
    }

    abstract void initialize();
}
