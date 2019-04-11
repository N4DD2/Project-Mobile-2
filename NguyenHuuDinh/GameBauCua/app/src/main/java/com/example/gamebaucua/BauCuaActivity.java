package com.example.gamebaucua;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface.OnClickListener;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BauCuaActivity extends AppCompatActivity implements OnClickListener {
    private GridView gridView;
    private Custom_Gridview_banco adapter;
    private Integer[] dshinh = {R.drawable.nai, R.drawable.bau, R.drawable.conga, R.drawable.conca, R.drawable.concua, R.drawable.contom};
    private AnimationDrawable cdxingau1, cdxingau2, cdxingau3;
    private ImageView hinhxingau1, hinhxingau2, hinhxingau3;
    private Random randomxingau;
    private int giatrixingau1, giatrixingau2, giatrixingau3;
    public static Integer[] gtdatcuoc = new Integer[6];
    private int tongtiencu, tongtienmoi;
    private TextView tvtien;
    private Timer timer = new Timer();
    private Handler handler;
    private int kiemtra;
    int tienthuong;
    CountDownTimer demthoigian;
    private SharedPreferences luutru;
    Handler.Callback callback = new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            randomxingau1();
            randomxingau2();
            randomxingau3();

            for (int i = 0; i < gtdatcuoc.length; i++) {
                if (gtdatcuoc[i] != 0) {
                    if (i == giatrixingau1) {
                        tienthuong += gtdatcuoc[i];
                    }
                    if (i == giatrixingau2) {
                        tienthuong += gtdatcuoc[i];
                    }
                    if (i == giatrixingau3) {
                        tienthuong += gtdatcuoc[i];
                    }
                    if (i != giatrixingau1 && i != giatrixingau2 && i != giatrixingau3) {
                        tienthuong -= gtdatcuoc[i];
                    }
                }
            }
            Log.d("kq", giatrixingau1 + "-"+ giatrixingau2 + "-" + giatrixingau3 + " Tiền thưởng: " + tienthuong);
            if (tienthuong > 0) {
                Toast.makeText(getApplicationContext(), "Chúc mừng bạn đã đoán trúng." + tienthuong, Toast.LENGTH_SHORT).show();
            } else if (tienthuong == 0) {
                Toast.makeText(getApplicationContext(), "Hòa vốn rồi.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Xui quá bạn đã mất: " + tienthuong, Toast.LENGTH_SHORT).show();
            }
            luudulieunguoidung(tienthuong);
            tvtien.setText(String.valueOf(tongtienmoi));
            tongtiencu = tongtienmoi;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bau_cua);

        hinhxingau1 = (ImageView) findViewById(R.id.xingau1);
        hinhxingau2 = (ImageView) findViewById(R.id.xingau2);
        hinhxingau3 = (ImageView) findViewById(R.id.xingau3);
        tvtien = (TextView) findViewById(R.id.tvtien);

        gridView = (GridView) findViewById(R.id.gvbanco);
        adapter = new Custom_Gridview_banco(this, R.layout.custombanco, dshinh);
        gridView.setAdapter(adapter);

        luutru = getSharedPreferences("Lưu trữ thông tin", Context.MODE_PRIVATE);
        tongtiencu = luutru.getInt("Tổng Tiền", 1000);
        tvtien.setText(String.valueOf(tongtiencu));

        //tang money cho nguoi choi

        demthoigian = new CountDownTimer(180000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long milis = millisUntilFinished;
            }

            @Override
            public void onFinish() {

            }
        };
        handler = new Handler(callback);

    }

    private void luudulieunguoidung(int tienthuong) {
        SharedPreferences.Editor edit = luutru.edit();
        tongtienmoi = tongtiencu + tienthuong;
        edit.putInt("Tổng Tiền", tongtienmoi);
        edit.commit();
    }

    public void lacxingau(View v) {
        hinhxingau1.setImageResource(R.drawable.hinhdongxingau);
        hinhxingau2.setImageResource(R.drawable.hinhdongxingau);
        hinhxingau3.setImageResource(R.drawable.hinhdongxingau);

        cdxingau1 = (AnimationDrawable) hinhxingau1.getDrawable();
        cdxingau2 = (AnimationDrawable) hinhxingau2.getDrawable();
        cdxingau3 = (AnimationDrawable) hinhxingau3.getDrawable();
        kiemtra = 0;
        for (int i = 0; i < gtdatcuoc.length; i++) {
            kiemtra += gtdatcuoc[i];
        }
        if (kiemtra == 0) {
            Toast.makeText(getApplicationContext(), "Bạn vui lòng đặt cược!", Toast.LENGTH_SHORT).show();
        } else {
            if (kiemtra > tongtiencu) {
                Toast.makeText(getApplicationContext(), "Bạn không đủ tiền đặt cược!", Toast.LENGTH_SHORT).show();
            } else {
                cdxingau1.start();
                cdxingau2.start();
                cdxingau3.start();
                tienthuong = 0;
                timer.schedule(new lacxingau(), 1000);
            }
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    class lacxingau extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);

        }
    }

    private void randomxingau1() {
        randomxingau = new Random();
        int rd = randomxingau.nextInt(6);
        switch (rd) {
            case 0:
                hinhxingau1.setImageResource(dshinh[0]);
                giatrixingau1 = rd;
                break;
            case 1:
                hinhxingau1.setImageResource(dshinh[1]);
                giatrixingau1 = rd;
                break;
            case 2:
                hinhxingau1.setImageResource(dshinh[2]);
                giatrixingau1 = rd;
                break;
            case 3:
                hinhxingau1.setImageResource(dshinh[3]);
                giatrixingau1 = rd;
                break;
            case 4:
                hinhxingau1.setImageResource(dshinh[4]);
                giatrixingau1 = rd;
                break;
            case 5:
                hinhxingau1.setImageResource(dshinh[5]);
                giatrixingau1 = rd;
                break;
        }
    }

    private void randomxingau2() {
        randomxingau = new Random();
        int rd = randomxingau.nextInt(6);
        switch (rd) {
            case 0:
                hinhxingau2.setImageResource(dshinh[0]);
                giatrixingau2 = rd;
                break;
            case 1:
                hinhxingau2.setImageResource(dshinh[1]);
                giatrixingau2 = rd;
                break;
            case 2:
                hinhxingau2.setImageResource(dshinh[2]);
                giatrixingau2 = rd;
                break;
            case 3:
                hinhxingau2.setImageResource(dshinh[3]);
                giatrixingau2 = rd;
                break;
            case 4:
                hinhxingau2.setImageResource(dshinh[4]);
                giatrixingau2 = rd;
                break;
            case 5:
                hinhxingau2.setImageResource(dshinh[5]);
                giatrixingau2 = rd;
                break;
        }
    }

    private void randomxingau3() {
        randomxingau = new Random();
        int rd = randomxingau.nextInt(6);
        switch (rd) {
            case 0:
                hinhxingau3.setImageResource(dshinh[0]);
                giatrixingau3 = rd;
                break;
            case 1:
                hinhxingau3.setImageResource(dshinh[1]);
                giatrixingau3 = rd;
                break;
            case 2:
                hinhxingau3.setImageResource(dshinh[2]);
                giatrixingau3 = rd;
                break;
            case 3:
                hinhxingau3.setImageResource(dshinh[3]);
                giatrixingau3 = rd;
                break;
            case 4:
                hinhxingau3.setImageResource(dshinh[4]);
                giatrixingau3 = rd;
                break;
            case 5:
                hinhxingau3.setImageResource(dshinh[5]);
                giatrixingau3 = rd;
                break;
        }
    }
}
