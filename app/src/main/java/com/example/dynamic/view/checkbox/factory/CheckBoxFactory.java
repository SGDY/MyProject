package com.example.dynamic.view.checkbox.factory;

import android.content.Context;
import android.widget.CheckBox;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class CheckBoxFactory {

    public abstract CheckBox createCheckBox(Context context, int type);
}
