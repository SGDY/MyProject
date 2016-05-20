package com.example.dynamic.view.edittext.factory;

import android.content.Context;
import android.widget.EditText;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public abstract class EditTextFactory {

    public abstract EditText createEditText(Context context, int type);

}
