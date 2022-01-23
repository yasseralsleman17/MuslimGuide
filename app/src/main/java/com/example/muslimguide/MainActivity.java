package com.example.muslimguide;

import static android.view.View.OnClickListener;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Button et_reg;
    Button et_log;



    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        FirebaseUser user = fAuth.getCurrentUser();

        if (user != null)

        {

            startActivity(new Intent(getApplicationContext(), MuslimHomePage.class));
        }

        et_log = findViewById(R.id.btn_sing_in);
        et_reg = findViewById(R.id.btn_register);
        et_reg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        et_log.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LogIn.class));

            }
        });
    }



}