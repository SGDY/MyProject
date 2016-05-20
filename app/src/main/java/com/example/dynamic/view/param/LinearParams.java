package com.example.dynamic.view.param;

import android.widget.LinearLayout;

/**
 * @author sg
 * @version 1.0
 * @description
 * @createDate 2015/6/30
 */
public class LinearParams {

    public static LinearLayout.LayoutParams getMMParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        return params;
    }
    public static LinearLayout.LayoutParams getMWParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return params;
    }
    public static LinearLayout.LayoutParams getWHParams(int w,int h) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(w, h);
        return params;
    }

    public static LinearLayout.LayoutParams getWWParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        return params;
    }

}
