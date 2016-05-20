package com.example.dynamic.view.radiobutton.decorate;

import android.widget.RadioButton;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
abstract public class RadioButtonDecorate {

    RadioButton customRadioButton;

    public RadioButtonDecorate(RadioButton customRadioButton) {
        this.customRadioButton = customRadioButton;
    }

    public RadioButton getCustomRadioButton() {
        return customRadioButton;
    }

    abstract void initialize();
}
