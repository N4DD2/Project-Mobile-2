package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class XemDiemActivity extends AppCompatActivity {
    TextView txtXemDiem , txtDiemCaoNhat;
    ImageButton ibtnReplay;
    SharedPreferences luuDiemSo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_diem);
        txtXemDiem = (TextView) findViewById(R.id.txtXemDiem);
        txtDiemCaoNhat = (TextView) findViewById(R.id.txtDiemCaoNhat);
        ibtnReplay = (ImageButton) findViewById(R.id.ibtnReplay);
        Intent intent = getIntent();
        int tongDiem = intent.getIntExtra("tongDiem", 0);
        luuDiemSo = getSharedPreferences("diemsogame" , MODE_PRIVATE);
        int diemcaonhat = luuDiemSo.getInt("diem" , 0);
        if(tongDiem > diemcaonhat){
            luudiem(tongDiem);
            txtXemDiem.setText(tongDiem+"");
            txtDiemCaoNhat.setText("Điểm cao nhất: " + tongDiem);

        } else {
            txtXemDiem.setText(tongDiem+"");
            txtDiemCaoNhat.setText("Điểm cao nhất: " + diemcaonhat);
        }
        ibtnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XemDiemActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void luudiem(int tongdiem){
        SharedPreferences.Editor editor = luuDiemSo.edit();
        editor.putInt("diem",tongdiem);
        editor.commit();
    }
}
