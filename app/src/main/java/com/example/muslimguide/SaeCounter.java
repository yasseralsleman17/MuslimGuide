package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SaeCounter extends AppCompatActivity {


    Button btn_Sae;
    TextView Sae_counter;
    int counter = -1;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sae_counter);

        Sae_counter = findViewById(R.id.Sae_counter);


        btn_Sae = findViewById(R.id.btn_Sae);

        btn_Sae.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (timer != null)
                                               timer.cancel();
                                           timer = new Timer();
                                           counter = -1;
                                           start();
                                       }
                                   }
        );
    }

    private void start() {

        {

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (counter != 7) {
                        counter++;
                        Sae_counter.setText(String.valueOf(counter));
                    } else
                        timer.cancel();
                }
            }, 0, 300000);
        }
    }

    @Override
    protected void onPause() {
        if (timer != null)
            timer.cancel();
        super.onPause();
    }
}

