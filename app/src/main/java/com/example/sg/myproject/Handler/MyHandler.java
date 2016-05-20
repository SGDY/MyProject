package com.example.sg.myproject.Handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sg.myproject.R;

/**
 * @author SGDY
 * @version 1.0
 * @description
 * @createDate 2015/1/18
 */
public class MyHandler extends Activity {

    private TextView tv;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        final Run run = new Run();
        thread = new Thread(run);
        thread.start();

        findViewById(R.id.btn).setOnClickListener(v -> run.mHandler.sendEmptyMessage(0));

    }

    class Run implements Runnable{

        public Handler mHandler;

        @Override
        public void run() {
            Looper.prepare();
            mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    /**
                     * 子线程中不能有UI组件的操作，UI组件只能在主线程中进行操作
                     */
                    Toast.makeText(MyHandler.this, "run", Toast.LENGTH_LONG).show();
                    super.handleMessage(msg);
                }
            };
            Looper.loop();
        }
    }
}
