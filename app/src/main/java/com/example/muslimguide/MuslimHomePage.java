package com.example.muslimguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MuslimHomePage extends AppCompatActivity {
    FirebaseAuth fAuth;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muslim_home_page);

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
                case R.id.Tracking_Hajj:
                    startActivity(new Intent(getApplicationContext(), TrackingHajj.class));
                    break;
                case R.id.Tracking_Umrah:
                    startActivity(new Intent(getApplicationContext(), TrackingUmrah.class));
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


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new Home();
                    break;
                case R.id.guide:
                    selectedFragment = new Guide();
                    break;
                case R.id.duaa:
                    selectedFragment = new Duaa();
                    break;
            }
            // It will help to replace the
            // one fragment to other.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}