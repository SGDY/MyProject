package com.example.broadcastbestpractice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.broadcastbestpractice.BaseActivity;
import com.example.broadcastbestpractice.R;

/**
 * Created by sg
 * Created Time 2015/3/29 12:28
 * Description
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(v -> {
            sendBroadcast(new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE"));
        });
    }
}
