package com.example.muslimguide;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText inputfull_name, inputuser_name, inputpassword, inputconfirm_password, inputemail;

    Button btn_register;
    ProgressDialog progressDialog;
    FirebaseAuth fauth;
    FirebaseUser muser;
    FirebaseFirestore fStore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = (Button) findViewById(R.id.btn_register_page);

        inputfull_name = (EditText) findViewById(R.id.full_name_reg);
        inputuser_name = (EditText) findViewById(R.id.user_name_reg);
        inputpassword = (EditText) findViewById(R.id.password_reg);
        inputemail = (EditText) findViewById(R.id.email_reg);
        inputconfirm_password = (EditText) findViewById(R.id.confirm_pass_reg);
        progressDialog = new ProgressDialog(this);
        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        muser = fauth.getCurrentUser();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuth();

            }
        });
    }

    private void performAuth() {
        String full_name = inputfull_name.getText().toString();
        String user_name = inputuser_name.getText().toString();
        String password = inputpassword.getText().toString();
        String confirm_password = inputconfirm_password.getText().toString();
        String email = inputemail.getText().toString();


        if (full_name.isEmpty()) {
            inputfull_name.setError("This field is required");
            return;
        }
        if (user_name.isEmpty()) {
            inputuser_name.setError("This field is required");
            return;
        }

        if (password.length() < 6) {
            inputpassword.setError("At least 6 characters");
            return;
        }
        if (!(password.equals(confirm_password))) {
            inputpassword.setError("Passwords must match");
            inputconfirm_password.setError("Passwords must match");
            return;
        }
        if (email.isEmpty()) {
            inputemail.setError("This field is required");
            return;
        }

            progressDialog.setMessage("please wait while registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "successful",
                                Toast.LENGTH_LONG).show();

                        userID = fauth.getCurrentUser().getUid();

                        DocumentReference groupReference = fStore.collection("Group").document(userID);

                        Map<String, Object> data = new HashMap<>();
                        data.put("count", String.valueOf(0));
                        groupReference.set(data)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user Profile is created for " + userID);


                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });

                        DocumentReference chatReference = fStore.collection("Chat").document(userID);

                        Map<String, Object> chatdata = new HashMap<>();
                        chatdata.put("count", String.valueOf(0));
                        chatReference.set(chatdata)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user Profile is created for " + userID);


                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });

                        DocumentReference documentReference = fStore.collection("User").document(userID);
                        Map<String, Object> user = new HashMap<>();
                        user.put("FullName", full_name);
                        user.put("UserName", user_name);
                        user.put("Password", password);
                        user.put("Email", email);
                        user.put("isAccepted", false);
                        user.put("Latitude", 0.0);
                        user.put("Longitude", 0.0);
                        user.put("Notice", false);

                        documentReference.set(user)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user Profile is created for " + userID);
                                        startActivity(new Intent(getApplicationContext(), MuslimHomePage.class));


                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure: " + e.toString());
                                    }
                                });

                        progressDialog.dismiss();



                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

    }
}