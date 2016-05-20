package com.example.dynamic.view.radiobutton.decorate;

import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.dynamic.view.param.LinearParams;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class RadioButtonDecorate1 extends RadioButtonDecorate {
    @Override
    void initialize() {
        customRadioButton.setPadding(5, 5, 5, 5);
        customRadioButton.setLayoutParams(LinearParams.getWWParams());
    }

    public RadioButtonDecorate1(RadioButton customRadioButton) {
        super(customRadioButton);
        initialize();
    }
}
