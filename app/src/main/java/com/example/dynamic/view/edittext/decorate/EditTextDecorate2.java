package com.example.dynamic.view.edittext.decorate;

import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.dynamic.view.param.LinearParams;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/29
 */
public class EditTextDecorate2 extends EditTextDecorate {

    public EditTextDecorate2(EditText customEditText) {
        super(customEditText);
        initialize();
    }

    @Override
    void initialize() {
        customEditText.setLayoutParams(LinearParams.getWHParams(130,45));
    }
}
