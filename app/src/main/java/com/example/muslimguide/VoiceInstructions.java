package com.example.muslimguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class VoiceInstructions extends AppCompatActivity {

    FirebaseAuth fAuth;


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;


    ImageButton bt_play_voice1, bt_play_voice2, bt_play_voice3, bt_play_voice4, bt_play_voice5, bt_play_voice6, bt_play_voice7, bt_play_voice8, bt_play_voice9, bt_play_voice10;


    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_instructions);

        fAuth = FirebaseAuth.getInstance();


        drawerLayout = findViewById(R.id.muslim_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        navigationView = findViewById(R.id.muslim_nav);

        navigationView.setNavigationItemSelectedListener((item) -> {

            switch (item.getItemId()) {
                case R.id.home_page:
                    startActivity(new Intent(getApplicationContext(), MuslimHomePage.class));
                    break;
                case R.id.hajj_guid:
                    startActivity(new Intent(getApplicationContext(), HajjGuid.class));
                    break;
                case R.id.umrah_guid:
                    startActivity(new Intent(getApplicationContext(), UmrahGuid.class));
                    break;
                case R.id.tawaaf_sae_counter:
                    startActivity(new Intent(getApplicationContext(), TawaafSaeCounter.class));
                    break;
                case R.id.voice_instructions:
                    startActivity(new Intent(getApplicationContext(), VoiceInstructions.class));
                    break;

                case R.id.add_group_member:
                    startActivity(new Intent(getApplicationContext(), AddGroupMember.class));
                    break;
                case R.id.chat:
                    startActivity(new Intent(getApplicationContext(), MemberList.class));
                    break;
                case R.id.log_out:
                    fAuth.signOut();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                    break;
            }
            return true;

        });


        bt_play_voice1  = findViewById(R.id.bt_play_voice1);
        bt_play_voice2  = findViewById(R.id.bt_play_voice2);
        bt_play_voice3  = findViewById(R.id.bt_play_voice3);
        bt_play_voice4  = findViewById(R.id.bt_play_voice4);
        bt_play_voice5  = findViewById(R.id.bt_play_voice5);
        bt_play_voice6  = findViewById(R.id.bt_play_voice6);
        bt_play_voice7  = findViewById(R.id.bt_play_voice7);
        bt_play_voice8  = findViewById(R.id.bt_play_voice8);
        bt_play_voice9  = findViewById(R.id.bt_play_voice9);
        bt_play_voice10 = findViewById(R.id.bt_play_voice10);


        bt_play_voice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v1);
                mp.setLooping(false);
                mp.seekTo(0);

                mp.start();
            }
        });

        bt_play_voice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v2);
                mp.setLooping(false);
                mp.seekTo(0);

                mp.start();
            }
        });

        bt_play_voice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v3);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v4);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v5);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v6);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v7);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v8);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v9);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

        bt_play_voice10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying();
                mp = MediaPlayer.create(getApplicationContext(), R.raw.v10);
                mp.setLooping(false);
                mp.seekTo(0);
                mp.start();
            }
        });

    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}