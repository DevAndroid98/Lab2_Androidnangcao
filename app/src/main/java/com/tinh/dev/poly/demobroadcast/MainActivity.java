package com.tinh.dev.poly.demobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt;





    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (EditText) findViewById(R.id.txt);
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                   String name=intent.getStringExtra("data");
                Toast.makeText(context, ""+name, Toast.LENGTH_SHORT).show();
            }
        };


        IntentFilter intentFilter=new IntentFilter("Demo");

        //đăng kí hệ thống

        registerReceiver(broadcastReceiver,intentFilter);

    }

    public void click(View view) {
        Intent intent=new Intent("Demo");
        intent.putExtra("data",txt.getText().toString());
        sendBroadcast(intent);
        }
}
