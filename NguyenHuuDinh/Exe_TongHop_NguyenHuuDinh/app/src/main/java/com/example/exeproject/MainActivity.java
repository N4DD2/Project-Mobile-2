package com.example.exeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEXE1 = (Button) findViewById(R.id.btnEXE1);
        Button btnEXE2 = (Button) findViewById(R.id.btnEXE2);
        Button btnEXE3 = (Button) findViewById(R.id.btnEXE3);
        Button btnEXE4 = (Button) findViewById(R.id.btnEXE4);
        Button btnEXE5 = (Button) findViewById(R.id.btnEXE5);

        btnEXE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeTuoi99Activity.class);
                startActivity(intent);
            }
        });

        btnEXE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        btnEXE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityExe3.class);
                startActivity(intent);
            }
        });
        btnEXE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityExe4.class);
                startActivity(intent);
            }
        });

        btnEXE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityExe5.class);
                startActivity(intent);
            }
        });

    }
}
