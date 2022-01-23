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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AddGroupMember extends AppCompatActivity {

    Button add_member;
    EditText member_email;
    String member_email_tx;


    FirebaseAuth fauth;
    FirebaseFirestore fStore;


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group_member);

        member_email = findViewById(R.id.member_email);

        add_member = findViewById(R.id.btn_add_member);

        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



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
                    fauth.signOut();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                    break;
            }
            return true;

        });




        add_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                member_email_tx = member_email.getText().toString();

                if (member_email_tx.isEmpty()) {

                    member_email.setError("email is requred!!");
                    return;
                }


                fStore.collection("User").get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @SuppressLint("UseCompatLoadingForDrawables")
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if (queryDocumentSnapshots.isEmpty()) {

                                    return;
                                } else {
                                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                                    for (int i = 0; i < list.size(); i++) {

                                        if (list.get(i).getString("Email").equals(member_email_tx)) {

                                            addnewmember(list.get(i));
                                            return;
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), "No account with this Email", Toast.LENGTH_LONG).show();


                                }
                            }
                        });
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    private void addnewmember(DocumentSnapshot membersnapshot) {
        // add to my group list
        DocumentReference documentReference = fStore.collection("Group").document(fauth.getCurrentUser().getUid());
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Map<String, Object> user = new HashMap<>();

                for (int j = 1; j <= Integer.parseInt(documentSnapshot.getString("count")); j++) {

                    if (documentSnapshot.getString(String.valueOf(j)).equals(membersnapshot.getId())) {
                        Toast.makeText(getApplicationContext(), "You have added this member before", Toast.LENGTH_LONG).show();
                        return;
                    }

                }

                user.put("count", String.valueOf((Integer.parseInt(documentSnapshot.getString("count")) + 1)));
                user.put(String.valueOf((Integer.parseInt(documentSnapshot.getString("count")) + 1)), membersnapshot.getId());

                documentReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "add new member successful", Toast.LENGTH_LONG).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        });

        //add me to other group list



        DocumentReference otherReference = fStore.collection("Group").document(membersnapshot.getId());


        otherReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                Map<String, Object> user = new HashMap<>();


                for (int j = 1; j <= Integer.parseInt(documentSnapshot.getString("count")); j++) {


                    if (documentSnapshot.getString(String.valueOf(j)).equals(fauth.getCurrentUser().getUid())) {
                        Toast.makeText(getApplicationContext(), "You have added this member before", Toast.LENGTH_LONG).show();
                        return;
                    }

                }



                user.put("count", String.valueOf((Integer.parseInt(documentSnapshot.getString("count")) + 1)));
                user.put(String.valueOf((Integer.parseInt(documentSnapshot.getString("count")) + 1)),fauth.getCurrentUser().getUid());




                otherReference.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "add new member successful", Toast.LENGTH_LONG).show();

                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_LONG).show();

                            }
                        });

            }
        });




         //add to my chat list

        DocumentReference mychat = fStore.collection("Chat").document(fauth.getCurrentUser().getUid());

        mychat.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                Map<String, Object> chatdata = new HashMap<>();


                chatdata.put("all_message","0");
                chatdata.put("last_message_received","0");

                Map<String, Object> user = new HashMap<>();


                user.put(membersnapshot.getId(), chatdata);




                mychat.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

            }
        });

         //add me to other chat list



        DocumentReference otherchat = fStore.collection("Chat").document(membersnapshot.getId());

        otherchat.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                Map<String, Object> chatdata = new HashMap<>();


                chatdata.put("all_message","0");
                chatdata.put("last_message_received","0");


                Map<String, Object> user = new HashMap<>();


                user.put(fauth.getCurrentUser().getUid(), chatdata);


                otherchat.update(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

            }
        });





    }
}