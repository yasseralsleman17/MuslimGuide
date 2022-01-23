package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Setting extends AppCompatActivity {
    Switch switch1;


    FirebaseAuth fauth;
    FirebaseFirestore fStore;


    boolean Notice = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        DocumentReference otherReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());

        otherReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Notice = documentSnapshot.getBoolean("Notice");
            }
        });


        switch1 = findViewById(R.id.switch1);
        switch1.setChecked(Notice);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    DocumentReference documentReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());
                    Map<String, Object> user = new HashMap<>();
                    user.put("Notice", true);
                    documentReference.update(user);
                } else {
                    DocumentReference documentReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());
                    Map<String, Object> user = new HashMap<>();
                    user.put("Notice", false);
                    documentReference.update(user);
                }

            }
        });

    }
}