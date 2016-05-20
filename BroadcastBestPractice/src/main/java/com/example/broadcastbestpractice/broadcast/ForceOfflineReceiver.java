package com.example.broadcastbestpractice.broadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;

import com.example.broadcastbestpractice.ActivityCollector;
import com.example.broadcastbestpractice.activity.LoginActivity;

public class ForceOfflineReceiver extends BroadcastReceiver {
    public ForceOfflineReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Warning");
        builder.setMessage("You are forced to be offline. please try to login again");
        builder.setCancelable(false);//
        builder.setPositiveButton("OK", (dialog, which) -> {
            ActivityCollector.finishAll();
            Intent intent1 = new Intent(context, LoginActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        });
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }
}
