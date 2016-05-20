package com.example.dynamic.view.edittext.decorate;

import android.widget.EditText;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/29
 */
abstract public class EditTextDecorate{

   EditText customEditText;

    public EditText getCustomEditText() {
        return customEditText;
    }

    public EditTextDecorate(EditText customEditText) {
        this.customEditText = customEditText;
    }

    abstract void initialize();
}
