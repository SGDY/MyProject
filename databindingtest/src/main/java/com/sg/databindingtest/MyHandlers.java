package com.sg.databindingtest;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 上官丹意 on 2016/07/04 13:26.
 */
public class MyHandlers {
    public void onClickFriend(View view) {
        Toast.makeText(view.getContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
    }
}
