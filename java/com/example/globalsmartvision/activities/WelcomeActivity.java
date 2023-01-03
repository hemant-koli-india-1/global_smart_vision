package com.example.globalsmartvision.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.globalsmartvision.R;

public class WelcomeActivity extends AppCompatActivity {
    Button Registeration;
    TextView SignIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Registeration= findViewById(R.id.button);
        SignIn = findViewById(R.id.SignIN);
        Registeration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
            }
        });
    SignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        }
    });
    }
}