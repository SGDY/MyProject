package com.example.dynamic.view.checkbox.decorate;

import android.widget.CheckBox;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
abstract public class CheckBoxDecorate {

    CheckBox customCheckBox;

    public CheckBoxDecorate(CheckBox customCheckBox) {
        this.customCheckBox = customCheckBox;
    }

    public CheckBox getCustomCheckBox() {
        return customCheckBox;
    }

    abstract void initialize();
}
