package com.sg.databindingtest;

import android.view.View;
import android.widget.Toast;

import com.sg.databindingtest.bean.User;

/**
 * Created by 上官丹意 on 2016/07/04 13:46.
 */
public class Presenter {

    public void onSaveClick(View view, User user) {
        Toast.makeText(view.getContext(), user.getLastName(), Toast.LENGTH_SHORT).show();
    }
}
