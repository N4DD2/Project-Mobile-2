package com.example.exeproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivityExe3 extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_exe3);

		setTitle(R.string.Exe3);
	}

	public void zoom(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
		image.startAnimation(animation);
	}

	public void clockwise(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
		image.startAnimation(animation1);
	}

	public void fade(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
		image.startAnimation(animation1);
	}

	public void blink(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
		image.startAnimation(animation1);
	}

	public void move(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
		image.startAnimation(animation1);
	}

	public void slide(View view){
		ImageView image = (ImageView)findViewById(R.id.imageView);
		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
		image.startAnimation(animation1);
	}


}