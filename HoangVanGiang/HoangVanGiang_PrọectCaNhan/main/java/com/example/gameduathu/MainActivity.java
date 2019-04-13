package camdich.com.dumv.game2048;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameduathu.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtDiem;
    private ImageButton ibntPlay;
    private CheckBox chkMot , chkHai, chkBa;
    private SeekBar sbrMot , sbrHai , sbrBa;
    private int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        sbrMot.setEnabled(false);
        sbrHai.setEnabled(false);
        sbrBa.setEnabled(false);
        txtDiem.setText(soDiem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000 , 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num = 5;
                Random random = new Random();
                int one = random.nextInt(num);
                int two = random.nextInt(num);
                int three = random.nextInt(num);

                //kiem tra win
                if(sbrMot.getProgress() >= sbrMot.getMax()){
                    this.cancel();
                    ibntPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "One Win" , Toast.LENGTH_SHORT).show();
                    if(chkMot.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác" , Toast.LENGTH_SHORT).show();
                    } else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi" , Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();

                }
                if(sbrHai.getProgress() >= sbrHai.getMax()){
                    ibntPlay.setVisibility(View.VISIBLE);
                    this.cancel();

                    Toast.makeText(MainActivity.this, "Two Win" , Toast.LENGTH_SHORT).show();
                    if(chkHai.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác" , Toast.LENGTH_SHORT).show();
                    } else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi" , Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();

                }
                if(sbrBa.getProgress() >= sbrBa.getMax()){
                    ibntPlay.setVisibility(View.VISIBLE);
                    this.cancel();

                    Toast.makeText(MainActivity.this, "Three Win" , Toast.LENGTH_SHORT).show();
                    if(chkBa.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác" , Toast.LENGTH_SHORT).show();
                    } else{
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi" , Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();

                }
                sbrMot.setProgress(sbrMot.getProgress() + one);
                sbrHai.setProgress(sbrHai.getProgress() + two);
                sbrBa.setProgress(sbrBa.getProgress() + three);
            }

            @Override
            public void onFinish() {
                chkMot.isChecked();
                chkHai.isChecked();
                chkBa.isChecked();
            }
        };
        ibntPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkMot.isChecked() || chkHai.isChecked() || chkBa.isChecked()){
                    sbrMot.setProgress(0);
                    sbrHai.setProgress(0);
                    sbrBa.setProgress(0);
                    ibntPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisnableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi" , Toast.LENGTH_SHORT).show();
                }

            }
        });

        chkMot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chkHai.setChecked(false);
                    chkBa.setChecked(false);
                }
            }
        });

        chkHai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chkMot.setChecked(false);
                    chkBa.setChecked(false);
                }
            }
        });

        chkBa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chkMot.setChecked(false);
                    chkHai.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckBox(){
        chkMot.setEnabled(true);
        chkHai.setEnabled(true);
        chkBa.setEnabled(true);
    }
    private void DisnableCheckBox(){
        chkMot.setEnabled(false);
        chkHai.setEnabled(false);
        chkBa.setEnabled(false);
    }
    private void AnhXa(){
        txtDiem = (TextView) findViewById(R.id.txtDiem);
        ibntPlay = (ImageButton) findViewById(R.id.btnPlay);
        chkMot = (CheckBox) findViewById(R.id.chkMot);
        chkHai = (CheckBox) findViewById(R.id.chkHai);
        chkBa = (CheckBox) findViewById(R.id.chkBa);
        sbrMot = (SeekBar) findViewById(R.id.sbrMot);
        sbrHai = (SeekBar) findViewById(R.id.sbrHai);
        sbrBa = (SeekBar) findViewById(R.id.sbrBa);
    }

}
