package com.example.dynamic.view.radiobutton.factory;

import android.content.Context;
import android.widget.RadioButton;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class RadioButtonFactory {

    public abstract RadioButton createRadioButton(Context context, int type);
}
