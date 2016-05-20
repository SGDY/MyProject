package com.example.dynamic.view.radiobutton;

import android.content.Context;
import android.widget.RadioButton;

import com.example.dynamic.view.radiobutton.factory.RadioButtonFactory;
import com.example.dynamic.view.radiobutton.factory.RadioButtonFactory1;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class CreateRadioButton {
    public static RadioButton getRadioButton(Context context, int type) {
        RadioButtonFactory radioButtonFactory = new RadioButtonFactory1();
        RadioButton radioButton = radioButtonFactory.createRadioButton(context, type);
        return radioButton;
    }
}
