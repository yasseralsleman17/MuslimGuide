package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TawaafSaeCounter extends AppCompatActivity {



    Button btn_sae,btn_tawaaf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tawaaf_sae_counter);

        btn_sae=findViewById(R.id.btn_sae);
        btn_sae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SaeCounter.class));

            }
        });

        btn_tawaaf=findViewById(R.id.btn_tawaaf);
        btn_tawaaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TawaafCounter.class));

            }
        });




    }
}