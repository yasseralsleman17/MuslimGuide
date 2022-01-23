package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class TawaafCounter extends AppCompatActivity {


    Button btn_tawaaf;
    TextView tawaff_counter;
    int counter=-1;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tawaaf_counter);
         timer=new Timer();

        tawaff_counter=findViewById(R.id.tawaff_counter);
        btn_tawaaf=findViewById(R.id.btn_tawaaf);
        btn_tawaaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=-1;
                start();
            }
        });
    }

    private void start() {



        {


            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if( counter!=7) {
                        counter++;
                        tawaff_counter.setText(String.valueOf(counter));
                    }
                    else
                        timer.cancel();
                }
            }, 0, 300000);

        }



    }

    @Override
    protected void onPause() {
        if (timer!=null)
            timer.cancel();
        super.onPause();
    }
}

