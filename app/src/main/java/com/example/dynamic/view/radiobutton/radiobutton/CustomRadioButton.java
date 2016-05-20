package com.example.dynamic.view.radiobutton.radiobutton;

import android.content.Context;
import android.widget.RadioButton;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class CustomRadioButton extends RadioButton {

    public Context context;

    public CustomRadioButton(Context context) {
        super(context);
        this.context = context;
    }

    abstract void initialize();
}
