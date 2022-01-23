package com.example.muslimguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
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

public class AdminHomePage extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    LinearLayout acountlinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        acountlinear = findViewById(R.id.account_linear);

        drawerLayout = findViewById(R.id.admin_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        navigationView = findViewById(R.id.admin_nav);

        navigationView.setNavigationItemSelectedListener((item) -> {

            switch (item.getItemId()) {

                case R.id.log_out2:

                    fAuth.signOut();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    break;

            }
            return true;

        });


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

                                viewaccount(list.get(i));


                            }
                        }


                    }
                });


    }

    private void viewaccount(DocumentSnapshot documentSnapshot) {

        View view = getLayoutInflater().inflate(R.layout.account_card, null);
        FrameLayout check = view.findViewById(R.id.check);
        if (documentSnapshot.getBoolean("isAccepted")) check.setBackgroundColor(Color.BLUE);
        if (!documentSnapshot.getBoolean("isAccepted")) check.setBackgroundColor(Color.GRAY);

        TextView username = view.findViewById(R.id.user_name);
        username.setText(documentSnapshot.getString("FullName"));

        TextView useremail = view.findViewById(R.id.user_email);
        useremail.setText(documentSnapshot.getString("Email"));

        ImageView add_account = view.findViewById(R.id.add_account);

        DocumentReference documentReference = fStore.collection("User").document(documentSnapshot.getId());


        add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (documentSnapshot.getBoolean("isAccepted")) return;

                Map<String, Object> userdata = new HashMap<>();

                userdata.put("isAccepted", true);

                documentReference.update(userdata)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                check.setBackgroundColor(Color.BLUE);
                                Toast.makeText(getApplicationContext(), "user Profile is added",
                                        Toast.LENGTH_LONG).show();


                            }
                        });
            }
        });


        ImageView delete_account = view.findViewById(R.id.delete_account);

        delete_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                documentReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {


                        Toast.makeText(getApplicationContext(), "user Profile is deleted",
                                Toast.LENGTH_LONG).show();

                        acountlinear.removeView(view);
                    }
                });


            }
        });


        acountlinear.addView(view);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}