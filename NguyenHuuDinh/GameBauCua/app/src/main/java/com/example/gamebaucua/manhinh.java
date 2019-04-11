package com.example.gamebaucua;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class manhinh extends Activity {
    ProgressBar bar;
    Handler handler;
    AtomicBoolean isrunning = new AtomicBoolean(false);
    TextView lblmsg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button btnstart, btnabout;

        bar = (ProgressBar) findViewById(R.id.progressBar1);
        btnstart = (Button) findViewById(R.id.btnstart);
        btnabout = (Button) findViewById(R.id.btnabout);
        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinh.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        //  btnstart.setOnClickListener(new View.OnClickListener() {

        //     public void onClick(View v) {
        //        Intent intent = new Intent(manhinh.this, MainActivity.class);
        //       startActivity(intent);
        //   }
        //  });
        //su kien cho progressbar
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
            }
        });
        handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //msg.arg1 là giá trị được trả về trong message
                //của tiến trình con
                bar.setProgress(msg.arg1);
                lblmsg.setText(msg.arg1 + "%");

            }

        };
        lblmsg = (TextView) findViewById(R.id.textView1);
    }
    private void doStart() {
        bar.setProgress(0);
        isrunning.set(false);
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                //vòng lặp chạy 100 lần
                for (int i = 0; i <= 100 && isrunning.get(); i++) {
                    //cho tiến trình tạm ngừng 100 mili second
                    SystemClock.sleep(20);
                    //lấy message từ Main thread
                    Message msg = handler.obtainMessage();
                    //gán giá trị vào cho arg1 để gửi về Main thread
                    msg.arg1 = i;
                    //gửi lại Message này về cho Main Thread
                    handler.sendMessage(msg);
                    if(i==100){
                        Intent intent = new Intent(manhinh.this, BauCuaActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        isrunning.set(true);
        //kích hoạt tiến trình
        th.start();

        //Intent intent = new Intent(manhinh.this, MainActivity.class);
        //startActivity(intent);
    }

}
