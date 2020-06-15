package com.example.simplesplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearSplash,linearMain;
    Animation fade_out, fade_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearSplash = findViewById(R.id.linearsplashId);
        linearMain = findViewById(R.id.linearmainId);
        fade_out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
        fade_in = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        linearMain.setVisibility(View.GONE);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                linearSplash.startAnimation(fade_out);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        linearSplash.setVisibility(View.GONE);
                        linearMain.setAnimation(fade_in);
                        linearMain.setVisibility(View.VISIBLE);


                        if (getSupportActionBar() != null) {
                            getSupportActionBar().show();
                        }

                    }
                }, 1000);

            }
        }, 4000);



    }
}
