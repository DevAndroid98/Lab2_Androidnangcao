package com.tinh.dev.poly.demobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText txt;
    private Button button;
    private BroadcastReceiver broadcastReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt =  findViewById(R.id.txt);
        button =  findViewById(R.id.button);
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String data=intent.getStringExtra("data");

                if (data.equals("")){
                    txt.setError("Không để trống");
                    return;
                }
                if (data.length()!=9){
                    txt.setError("Chuỗi nhập vào phải có đủ 9 kí tự");
                    return;
                }
                if (!data.startsWith("MEM") && !data.startsWith("VIP") ){
                    txt.setError("Bắt đầu phải là MEM hoặc VIP");
                    return;
                }

                if (data.equalsIgnoreCase("MEM537128")){
                    Toast.makeText(context, "Khuyến mãi 10%", Toast.LENGTH_SHORT).show();
                }
                if (data.equalsIgnoreCase("MEM537129")){
                    Toast.makeText(context, "Khuyến mãi 20%", Toast.LENGTH_SHORT).show();
                }

                if (data.equalsIgnoreCase("VIP537128")){
                    Toast.makeText(context, "Khuyến mãi 30%", Toast.LENGTH_SHORT).show();
                }

                if (data.equalsIgnoreCase("VIP537129")){
                    Toast.makeText(context, "Khuyến mãi 50%", Toast.LENGTH_SHORT).show();
                }




            }
        };

        IntentFilter intentFilter=new IntentFilter("Data");
        registerReceiver(broadcastReceiver,intentFilter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=txt.getText().toString();
                Intent intent=new Intent("Data");
                intent.putExtra("data",data);
                sendBroadcast(intent);
            }
        });
    }
}
