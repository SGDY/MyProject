package com.example.dynamic.view.edittext.factory;

import android.content.Context;
import android.widget.EditText;

import com.example.dynamic.view.edittext.decorate.EditTextDecorate1;
import com.example.dynamic.view.edittext.decorate.EditTextDecorate2;
import com.example.dynamic.view.edittext.edittext.MyEditText1;
import com.example.dynamic.view.edittext.edittext.MyEditText2;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class EditTextFactory1 extends EditTextFactory {
    @Override
    public EditText createEditText(Context context, int type) {
        EditText editText = null;
        switch (type) {
            case 1:
                editText = new EditTextDecorate2(new MyEditText1(context)).getCustomEditText();
                break;
            case 2:
                editText = new EditTextDecorate1(new MyEditText2(context)).getCustomEditText();
                break;
            default:
                break;
        }
        return editText;
    }
}
