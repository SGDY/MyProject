package com.sgdy.mediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sgdy.mediaplayer.music.MusicActivity;
import com.sgdy.mediaplayer.video.VideoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_music).setOnClickListener(this);
        findViewById(R.id.btn_video).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_music:
                startActivity(new Intent(this, MusicActivity.class));
                break;
            case R.id.btn_video:
                startActivity(new Intent(this, VideoActivity.class));
                break;
        }
    }
}
