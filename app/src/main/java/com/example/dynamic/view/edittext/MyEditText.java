package com.example.dynamic.view.edittext;

import android.content.Context;
import android.widget.EditText;

import com.example.sg.myproject.R;

/**
 * TODO: document your custom view class.
 */
public class MyEditText extends EditText {

    private Context context;

    public MyEditText(Context context) {
        super(context);
        this.context = context;
        initialize();
    }

    private void initialize() {
        setBackground(context.getResources().getDrawable(R.drawable.shape_et_background));
    }
}
