package com.example.sg.myproject.SharedPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/1/17
 */
public class SharedPreferencesActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * SharedPreferences创建的两种方式
         */
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences prefs1 = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        super.onCreate(savedInstanceState);
    }
}
