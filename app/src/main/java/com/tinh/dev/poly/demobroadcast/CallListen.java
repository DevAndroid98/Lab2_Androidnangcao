package com.tinh.dev.poly.demobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CallListen extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Có cuộc gọi đến", Toast.LENGTH_SHORT).show();
    }
}
