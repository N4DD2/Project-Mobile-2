package camdich.com.dumv.game2048;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton btnFish = (ImageButton) findViewById(R.id.btnFish);
        ImageButton btnGame2048 = (ImageButton) findViewById(R.id.btn2048);
        ImageButton btnGameDuaThu = (ImageButton)findViewById(R.id.btnDuathu);
        ImageButton btnSpeedMatch = (ImageButton) findViewById(R.id.btnSpeedMtach);
        ImageButton btnBauCua = (ImageButton) findViewById(R.id.btnBauCua);

        btnGame2048.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnGameDuaThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DuaThuActivity.class);
                startActivity(intent);
            }
        });

        btnSpeedMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SpeedMatchActivity.class);
                startActivity(intent);
            }
        });

        btnBauCua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, manhinh.class);
                startActivity(intent);
            }
        });

        btnFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(HomeActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

    }
}
