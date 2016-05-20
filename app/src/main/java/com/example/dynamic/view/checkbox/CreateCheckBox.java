package com.example.dynamic.view.checkbox;

import android.content.Context;
import android.widget.CheckBox;

import com.example.dynamic.view.checkbox.factory.CheckBoxFactory;
import com.example.dynamic.view.checkbox.factory.CheckBoxFactory1;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class CreateCheckBox {

    public static CheckBox getCheckBox(Context context, int type) {
        CheckBoxFactory checkBoxFactory = new CheckBoxFactory1();
        CheckBox checkBox = checkBoxFactory.createCheckBox(context, type);
        return checkBox;
    }
}
