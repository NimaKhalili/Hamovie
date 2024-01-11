package com.example.hamovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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
}