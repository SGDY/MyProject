package com.example.dynamic.view.edittext.decorate;

import android.widget.EditText;

import com.example.dynamic.view.param.LinearParams;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/29
 */
public class EditTextDecorate1 extends EditTextDecorate {

    public EditTextDecorate1(EditText customEditText) {
        super(customEditText);
        initialize();
    }

    @Override
    void initialize() {
        customEditText.setLayoutParams(LinearParams.getMWParams());
    }
}
