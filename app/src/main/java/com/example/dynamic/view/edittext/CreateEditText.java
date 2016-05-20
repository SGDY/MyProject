package com.example.dynamic.view.edittext;

import android.content.Context;
import android.widget.EditText;

import com.example.dynamic.view.edittext.factory.EditTextFactory;
import com.example.dynamic.view.edittext.factory.EditTextFactory1;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class CreateEditText {

    public static EditText getEditText(Context context, int type) {
        EditTextFactory editTextFactory = new EditTextFactory1();
        EditText editText = editTextFactory.createEditText(context, type);
        return editText;
    }

}
