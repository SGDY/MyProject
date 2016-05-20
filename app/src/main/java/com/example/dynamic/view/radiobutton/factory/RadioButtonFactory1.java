package com.example.dynamic.view.radiobutton.factory;

import android.content.Context;
import android.widget.RadioButton;

import com.example.dynamic.view.radiobutton.decorate.RadioButtonDecorate1;
import com.example.dynamic.view.radiobutton.radiobutton.MyRadioButton1;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class RadioButtonFactory1 extends RadioButtonFactory {
    @Override
    public RadioButton createRadioButton(Context context, int type) {
        RadioButton radioButton = null;
        switch (type) {
            case 1:
                radioButton = new RadioButtonDecorate1(new MyRadioButton1(context)).getCustomRadioButton();
                break;
            case 2:
                break;
            default:
                break;
        }
        return radioButton;
    }
}
