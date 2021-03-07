package com.example.project007.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chaos.view.PinView;
import com.example.project007.R;

public class Verifcation extends AppCompatActivity {
    PinView pinUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifcation);

        pinUser = findViewById(R.id.pin);

        String phone = getIntent().getStringExtra("phone");
        
    }
}