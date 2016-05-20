package com.example.dynamic.view.checkbox.factory;

import android.content.Context;
import android.widget.CheckBox;

import com.example.dynamic.view.checkbox.checkbox.MyCheckBox1;
import com.example.dynamic.view.checkbox.decorate.CheckBoxDecorate1;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class CheckBoxFactory1 extends CheckBoxFactory {
    @Override
    public CheckBox createCheckBox(Context context, int type) {
        CheckBox checkBox = null;
        switch (type) {
            case 1:
                checkBox = new CheckBoxDecorate1(new MyCheckBox1(context)).getCustomCheckBox();
                break;
            case 2:
                break;
            default:
                break;
        }
        return checkBox;
    }
}
