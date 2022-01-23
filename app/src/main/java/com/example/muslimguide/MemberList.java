package com.example.muslimguide;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MemberList extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    LinearLayout linearmemberlist;


    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        linearmemberlist = findViewById(R.id.linearmemberlist);

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


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        fStore.collection("Group").document(fAuth.getCurrentUser().getUid()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {


                        for (int j = 1; j <= Integer.parseInt(documentSnapshot.getString("count")); j++) {


                            showmember(documentSnapshot.getString(String.valueOf(j)));


                        }


                    }
                });


    }

    private void showmember(String member_id) {


        View view = getLayoutInflater().inflate(R.layout.member, null);

        TextView username = view.findViewById(R.id.member_name);
        Button chat = view.findViewById(R.id.member_chat);

        fStore.collection("User").document(member_id).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                            username.setText(documentSnapshot.getString("FullName"));

                    }
                });


        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), ChatPage.class);
                i.putExtra("member_id", member_id);
                i.putExtra("member_name",username.getText().toString());
                    startActivity(i);

            }
        });


        linearmemberlist.addView(view);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}