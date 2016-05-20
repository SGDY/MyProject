package com.example.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class MyService extends Service {

    public final String TAG = this.getClass().getSimpleName();
    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "startDownload executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress executed");
            return 0;
        }
    }

    /**
     * 服务创建时使用，每次创建时只会被调用一次
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate executed");

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher);// 设置小图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));//设置大图标
        builder.setTicker("notification comes");//设置状态栏显示信息
        builder.setWhen(System.currentTimeMillis());//设置通知发生时间
        builder.setAutoCancel(true);//设置可以清除
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("This is title");
        builder.setContentText("This is content");
        builder.setContentInfo("This is info");
        builder.setContentIntent(contentIntent);
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_ONGOING_EVENT;//表明有程序运行，不可由用户清除
        startForeground(1,notification);

    }

    /**
     * 每次服务启动时调用，可以多次被调用
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 服务销毁时调用
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy executed");
    }
}
