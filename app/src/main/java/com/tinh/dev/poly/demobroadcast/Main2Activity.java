package com.tinh.dev.poly.demobroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click(View view) {
        Intent intent=new Intent(this,CallListen.class);
        intent.putExtra("data","Hello Word");
        sendBroadcast(intent);
    }
}
