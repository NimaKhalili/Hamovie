package com.example.hamovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.imageView_splash_logo);
        TextView title = findViewById(R.id.textView_splash_title);

        Animation logoAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_from_right);
        logo.startAnimation(logoAnimation);
        Animation titleAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_from_left);
        title.startAnimation(titleAnimation);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 2500);
    }
}