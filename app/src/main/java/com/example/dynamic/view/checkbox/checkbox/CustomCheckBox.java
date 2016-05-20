package com.example.dynamic.view.checkbox.checkbox;

import android.content.Context;
import android.widget.CheckBox;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class CustomCheckBox extends CheckBox {

    public Context context;

    public CustomCheckBox(Context context) {
        super(context);
        this.context = context;
    }

    abstract void initialize();

}
