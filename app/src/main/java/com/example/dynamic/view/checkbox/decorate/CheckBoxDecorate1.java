package com.example.dynamic.view.checkbox.decorate;

import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.dynamic.view.param.LinearParams;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class CheckBoxDecorate1 extends CheckBoxDecorate {

    public CheckBoxDecorate1(CheckBox customCheckBox) {
        super(customCheckBox);
        initialize();
    }

    @Override
    void initialize() {
        customCheckBox.setPadding(5,5,5,5);
        customCheckBox.setLayoutParams(LinearParams.getWWParams());
    }
}
