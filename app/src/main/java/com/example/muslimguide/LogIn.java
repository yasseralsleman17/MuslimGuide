package com.example.muslimguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {


    EditText mEmail, mPassword;
    Button mLoginBtn;
    ProgressDialog progressDialog;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mLoginBtn = (Button) findViewById(R.id.btn_sing_in_page);
        mEmail = (EditText) findViewById(R.id.email_sign);
        mPassword = (EditText) findViewById(R.id.password_sign);

        progressDialog = new ProgressDialog(this);
        fAuth = FirebaseAuth.getInstance();


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    mEmail.setError("This field is required");
                    return;
                }
                if (password.length() < 6) {
                    mPassword.setError("At least 6 characters");
                    return;
                }

                progressDialog.setMessage("please wait while sign in");
                progressDialog.setTitle("sign in");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                fAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(getApplicationContext(), "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                    if (email.equals("admin@gmail.com"))
                                    {
                                        startActivity(new Intent(getApplicationContext(), AdminHomePage.class));
                                    }
                                    else
                                        {
                                            startActivity(new Intent(getApplicationContext(), MuslimHomePage.class));
                                        }
                                    progressDialog.dismiss();
                                } else {
                                    progressDialog.dismiss();

                                    Toast.makeText(getApplicationContext(), "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }
}