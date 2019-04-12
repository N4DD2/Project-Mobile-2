package camdich.com.dumv.game2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class SpeedMatchActivity extends AppCompatActivity {
    ImageButton btnPlay , btnYes, btnNo;
    ImageView imgChim;
    TextView txtThoiGian , txtTongDiem , txtCombo;
    ArrayList<String> arrayList;
    Random rd;
    int index;
    int idImg1;
    int idImg2;
    long t = 20;
    CountDownTimer times;
    int diem = 0 ;
    int dem = 0;
    int bonus = 5;
    int tile = 0;
    Animation animation;
    Animation animation2;
    int rePlay = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_match);
        setTitle("Speed Match");
        //Anh xa
        btnPlay = (ImageButton) findViewById(R.id.ibtnPlay);
        btnYes = (ImageButton) findViewById(R.id.ibtnYes);
        btnNo = (ImageButton) findViewById(R.id.ibtnNo);

        btnYes.setVisibility(View.INVISIBLE);
        btnNo.setVisibility(View.INVISIBLE);

        txtThoiGian = (TextView) findViewById(R.id.txtThoiGian);
        txtTongDiem = (TextView) findViewById(R.id.txtTongDiem);
        txtCombo = (TextView) findViewById(R.id.txtCombo);
        imgChim = (ImageView) findViewById(R.id.imageChim);

        animation = AnimationUtils.loadAnimation(SpeedMatchActivity.this , R.anim.chuyen_hinh);
        animation2 = AnimationUtils.loadAnimation(SpeedMatchActivity.this , R.anim.combo);
        String []item = getResources().getStringArray(R.array.list_name);
        arrayList = new ArrayList<>(Arrays.asList(item));
        rd = new Random();
        index = rd.nextInt(3);
        idImg1 = getResources().getIdentifier(arrayList.get(index),"drawable" , getPackageName());
        imgChim.setImageResource(idImg1);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setVisibility(View.INVISIBLE);
                btnYes.setVisibility(View.VISIBLE);
                btnNo.setVisibility(View.VISIBLE);
                if(rePlay == 0){
                    index = rd.nextInt(3);
                    idImg2 = getResources().getIdentifier(arrayList.get(index), "drawable" , getPackageName());
                }
                imgChim.setImageResource(idImg2);
                imgChim.setAnimation(animation);
                animation.start();
                times = new CountDownTimer(t * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        txtThoiGian.setText((t-1)+"");
                        t = t-1;
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(SpeedMatchActivity.this , XemDiemActivity.class);
                        intent.putExtra("tongDiem", diem);
                        startActivity(intent);

                    }
                }.start();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnYes.setEnabled(false);
                btnNo.setEnabled(false);
                if(idImg1 != idImg2){
                    dem++;
                    diem = diem + 10 + (dem-1)*bonus;
                }else {
                    dem = 0;
                    diem = diem - 5;
                    if (diem <= 0)
                        diem = 0;
                }
                txtTongDiem.setText(diem+"");
                idImg1 = idImg2;
                tile = rd.nextInt(2);
                if(tile == 1)
                    idImg2 = idImg1;
                else {
                    while (idImg1 == idImg2){
                        index = rd.nextInt(3);
                        idImg2 = getResources().getIdentifier(arrayList.get(index), "drawable" , getPackageName());
                    }
                }
                imgChim.setImageResource(idImg2);
                imgChim.setAnimation(animation);
                animation.start();
                if (dem >= 5) dem = 5;
                if (dem > 1)
                    txtCombo.setText("Combo x" + dem);
                if (dem == 5)
                    txtCombo.setText("Perfect");
                txtCombo.startAnimation(animation2);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        btnYes.setEnabled(true);
                        btnNo.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnYes.setEnabled(false);
                btnNo.setEnabled(false);
                if(idImg1 == idImg2){
                    dem++;
                    diem = diem + 10 + (dem-1)*bonus;
                }else {
                    dem = 0;
                    diem = diem - 5;
                    if (diem <= 0)
                        diem = 0;
                }
                txtTongDiem.setText(diem+"");
                idImg1 = idImg2;
                tile = rd.nextInt(2);
                if(tile == 1)
                    idImg2 = idImg1;
                else {
                    while (idImg1 == idImg2){
                        index = rd.nextInt(3);
                        idImg2 = getResources().getIdentifier(arrayList.get(index), "drawable" , getPackageName());
                    }
                }
                imgChim.setImageResource(idImg2);
                imgChim.setAnimation(animation);
                animation.start();
                if (dem >= 5) dem = 5;
                if (dem > 1)
                    txtCombo.setText("Combo x" + dem);
                if (dem == 5)
                    txtCombo.setText("Perfect");
                txtCombo.startAnimation(animation2);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        btnYes.setEnabled(true);
                        btnNo.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pause,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        btnPlay.setVisibility(View.VISIBLE);
        btnYes.setVisibility(View.INVISIBLE);
        btnNo.setVisibility(View.INVISIBLE);
        rePlay = 1;
        times.cancel();
        t = t+1;
        return super.onOptionsItemSelected(item);
    }
}
