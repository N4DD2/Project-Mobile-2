package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    TextView txtTitle , txtTimeSong , txtTimeTotal;
    SeekBar skSong;
    ImageView imgHinh;
    ImageButton btnPrev , btnPlay , btnStop ,  btnNext;
    ArrayList<Song> arraySong;
    int Position = 0;
    MediaPlayer mediaPlayer;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        AddSong();
        animation = AnimationUtils.loadAnimation(this , R.anim.desc_rotate);
        KhoiTaoMediaPlayer();
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Position--;
                if(Position < 0) {
                    Position = arraySong.size() -1 ;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play);
                }else
                {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                }
                SetTimeTotal();
                UpdateTimeSong();
                imgHinh.setAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                btnPlay.setImageResource(R.drawable.ic_play);
                KhoiTaoMediaPlayer();
                SetTimeTotal();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Position++;
                if(Position > arraySong.size() -1) {
                    Position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoiTaoMediaPlayer();
                mediaPlayer.start();
                btnPlay.setImageResource(R.drawable.ic_pause);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });
    }
    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDanggio = new SimpleDateFormat("mm:ss");
                txtTimeSong.setText(dinhDanggio.format(mediaPlayer.getCurrentPosition()));
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Position++;
                        if(Position > arraySong.size() -1) {
                            Position = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoiTaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlay.setImageResource(R.drawable.ic_pause);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this, 500);
            }
        },100);
    }

    private void SetTimeTotal(){
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(dinhDangGio.format(mediaPlayer.getDuration()));
        //gán max của skSong = mediaPlayer.getDuration()
        skSong.setMax(mediaPlayer.getDuration());
    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("despacito" , R.raw.despacito));
        arraySong.add(new Song("machine" , R.raw.machine));
        arraySong.add(new Song("undisputed" , R.raw.undisputed));
    }


    private void AnhXa() {
        txtTimeSong = (TextView) findViewById(R.id.txtTg1);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTimeTotal = (TextView) findViewById(R.id.txtTg2);
        skSong = (SeekBar) findViewById(R.id.skb1);
        btnPrev = (ImageButton) findViewById(R.id.Ibtn1);
        btnPlay = (ImageButton) findViewById(R.id.Ibtn2);
        btnStop = (ImageButton) findViewById(R.id.Ibtn3);
        btnNext = (ImageButton) findViewById(R.id.Ibtn4);
        imgHinh = (ImageView) findViewById(R.id.imageViewDisc);
    }

    private void KhoiTaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(MainActivity.this , arraySong.get(Position).getFile());
        txtTitle.setText(arraySong.get(Position).getFile());
    }
}
