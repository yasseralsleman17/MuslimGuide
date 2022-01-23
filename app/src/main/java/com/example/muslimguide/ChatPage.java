package com.example.muslimguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
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
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ChatPage extends AppCompatActivity {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;


    ImageView bt_message;
    EditText ed_message;
    TextView chat_member_name;

    String  mymessage;

    LinearLayout linearmessages;


    String member_id, member_name = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_page);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            member_id = extras.getString("member_id");
            member_name = extras.getString("member_name");

        }
        chat_member_name = findViewById(R.id.chat_member_name);

        chat_member_name.setText(member_name);
        linearmessages = findViewById(R.id.linearmessages);


        fAuth = FirebaseAuth.getInstance();
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
                    // startActivity(new Intent(getApplicationContext(), .class));
                    break;
                case R.id.umrah_guid:
                    //  startActivity(new Intent(getApplicationContext(), .class));
                    break;
                case R.id.tawaaf_sae_counter:
                    //  startActivity(new Intent(getApplicationContext(), .class));
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


        ed_message = findViewById(R.id.ed_message);
        bt_message = findViewById(R.id.bt_message);

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mymessage = ed_message.getText().toString();

                if (!mymessage.isEmpty()) {

                    sendmymessage(mymessage);

                    ed_message.setText("");
                }
            }
        });



        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               getmessage();
            }
        }, 0, 5000);



    }

    private void getmessage() {
if(fAuth.getCurrentUser().getUid()!= null) {

    DocumentReference mychat = fStore.collection("Chat").document(fAuth.getCurrentUser().getUid());

    mychat.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onSuccess(DocumentSnapshot documentSnapshot) {

            Map<String, Object> chat_data = (Map<String, Object>) documentSnapshot.get(member_id);
            String all_message = (String) chat_data.get("all_message");
            String last_message_received = (String) chat_data.get("last_message_received");
            int all_message_num = Integer.parseInt(all_message);
            int last_message_received_num = Integer.parseInt(last_message_received);

            for (int i = last_message_received_num; i < all_message_num; i++) {
                recivemessage((String) chat_data.get(String.valueOf(i+1)));

            }
            if (all_message_num > last_message_received_num) {

                chat_data.replace("last_message_received", String.valueOf(all_message_num));

                Map<String, Object> user = new HashMap<>();
                user.put(member_id, chat_data);

                mychat.update(user);
            }

        }
    });

}
    }

    private void sendmymessage(String mymessage) {


        View view = getLayoutInflater().inflate(R.layout.my_message, null);
        TextView username = view.findViewById(R.id.mymessagetext);
        username.setText(mymessage);

        DocumentReference otherchat = fStore.collection("Chat").document(member_id);
        otherchat.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Map<String, Object>  chat_data= (Map<String, Object>) documentSnapshot.get(fAuth.getCurrentUser().getUid());
                String last_messege_num = (String) chat_data.get("all_message");
                int message_num =Integer.parseInt(last_messege_num);
                message_num++;

                chat_data.put("all_message",String.valueOf(message_num));
                chat_data.put(String.valueOf(message_num),mymessage);

                Map<String, Object> user = new HashMap<>();

                user.put(fAuth.getCurrentUser().getUid(), chat_data);

                otherchat.update(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
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






        linearmessages.addView(view);


    }


    private void recivemessage(String othermessage) {





        View view = getLayoutInflater().inflate(R.layout.other_message, null);


        TextView username = view.findViewById(R.id.othermessagetext);
        username.setText(othermessage);


        linearmessages.addView(view);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}