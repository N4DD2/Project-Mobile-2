package com.example.saru.detuoi99;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeTuoi99Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.de_tuoi_99_layout);

        Button btnKhuA = (Button) findViewById(R.id.btnKhuA);
        Button btnKhuB = (Button) findViewById(R.id.btnKhuB);
        Button btnKhuC = (Button) findViewById(R.id.btnKhuC);

        btnKhuB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeTuoi99Activity.this, KhuBActivity.class);
                startActivity(intent);
            }
        });
    }

}
