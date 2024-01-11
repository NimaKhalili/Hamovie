package com.example.hamovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Do not run activity if the user is registered
        if (checkUserData())
            login();

        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        EditText username = findViewById(R.id.editText_login_username);
        EditText password = findViewById(R.id.editText_login_password);
        Button login = findViewById(R.id.button_login_login);

        login.setOnClickListener(view -> {
            if (!username.getText().toString().isEmpty() || !password.getText().toString().isEmpty()) {
                if (username.getText().toString().trim().equals("admin") && password.getText().toString().trim().equals("12345")) {
                    saveUserData();
                    login();
                } else {
                    Toast.makeText(this, "نام کاربری یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "لطفا تمام گزینه ها را پر کنید", Toast.LENGTH_SHORT).show();
            }
        });

        prepareAnime();
    }

    private void prepareAnime() {
        // Add a callback that's called when the splash screen is animating to the
        // app content.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            getSplashScreen().setOnExitAnimationListener(splashScreenView -> {
                final ObjectAnimator slideUp = ObjectAnimator.ofFloat(
                        splashScreenView,
                        View.TRANSLATION_Y,
                        0f,
                        -splashScreenView.getHeight()
                );
                slideUp.setInterpolator(new AnticipateInterpolator());
                slideUp.setDuration(2000L);

                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splashScreenView.remove();
                    }
                });

                // Run your animation.
                slideUp.start();
            });
        }
    }

    private void login() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "خوش آمدید", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void saveUserData() {
        SharedPreferences sharedPreferences =
                getApplicationContext().getSharedPreferences("USER_DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("USER_STATE", true);
        editor.apply();
    }

    private boolean checkUserData() {
        SharedPreferences sharedPreferences =
                getApplicationContext().getSharedPreferences("USER_DATA", MODE_PRIVATE);
        boolean getUserState = sharedPreferences.getBoolean("USER_STATE", false);
        return getUserState;
    }

    @Override
    protected void onResume() {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= android.os.Build.VERSION_CODES.S) //public static final S = 31 //Android 12
        {
            getSplashScreen().setSplashScreenTheme(R.style.Theme_App_Starting);
        }
        super.onResume();
    }
}