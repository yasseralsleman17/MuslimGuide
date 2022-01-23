package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TrackingHajj extends AppCompatActivity {

    TextView hajj_text;

    Button btn_hajj_next;
    int index=0;
    MediaPlayer mp;
    String[] items = new String[]{
//1
            "تبدأ من الميقات\n" +
                    "\n" +
                    "\n" +
                    "·تًجرّد من الثياب، واغتسل كما تغتسل من الجنابة – إن تيسر لك – وتطيب بأطيب ما تجده من دهن عود أو غيره في رأسك ولحيتك، ولا يضر بقاء ذلك بعد الإحرام، ولكن لا تطيب ثياب الإحرام.\n" +
                    "\n"

//2
            ,

          "  توجه إلى المسجد الحرام للطواف\n" +
            "\n" +
            " \n" +
            "\n" +
            "عند رؤيتك للبيت كبر وقل: \"اللهم زد هذا البيت تشريفاً وتعظيماً وتكريماً ومهابة وأمناً، وزد من   شرفه وكرمه ممن حجه أو اعتمره تشريفاً وتكريماً وتعظيماً وبِراً\".\n" +
            "\n"
            //3

            ,
            "\n" +
                    "\n" +
                    "·اذهب إلى زمزم واشرب منها واحمد الله\n\n"

            //4
            ,
            "اخرج إلى الصفا للسعي\n" +
                    "\n" +
                    " \n"
//5
            ,

            "الحلق أو التقصير\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "·إذا أكملت السعي، احلق شعرك أو قصره والحلق أفضل (أما إذا كان قدومك مكة قريباً من وقت الحج فالتقصير أفضل لتحلق بقية شعرك في الحج). (أما المرأة فتقصر من كل ظفيرة قدر أنملة).\n" +
                    "\n" +
                    "\n"
            //6
            ,

            "\n" +
                    "1.    المبيت بمنى هذا اليوم (وهو من وقت غروب الشمس يوم الثامن من ذي الحجة إلى قرب طلوع فجر يوم عرفة).\n" +
                    "\n"+
                    "\n"
            //7
            ,

            "\n" +
                    "\n" +
                    "2. إذا طلعت الشمس فسر إلى عرفة.\n"
            //8
            ,

            "\n" +
                    "أ- إذا غربت الشمس، اذهب إلى مزدلفة فإذا وصلتها صل المغرب والعشاء (جمعاً وقصراً بأذان واحد وإقامتين) قبل أن تحط رحلك، وقبل جمع الحصى.\n" +
                    "\n" +
                    "\n"
            //9
            ,
            "\n" +
                    "\n" +
                    "ج- التقط سبع حصيات لرمي جمرة العقبة الأولى ومن أي مكان أخذتها جاز.\n" +
                    "\n" +
                    "\n" +
                    "د- اذهب إلى منى قبل طلوع الشمس.\n"
            //10
,

            "\n" +
                    " بعد رمي جمرة العقبة اذهب ل مكة لطواف الإفاضة، .\n" +
                    "\n" +   "\n"
            //11
            ,
            "\n" +
                    "\n" +
                    " المبيت بمنى أيام التشريق: والمقصود بالمبيت أن يدركك الليل – ولو لحظة   منه – وأنت بمنى حتى لو كنت يقظان أو ماشياً ولا يلزمك النوم.\n"+
                    "\n" +
                    "\n"
//12
            ,

            "\n" +
                    "1.    رمي الجمرات أيام التشريق:\n" +
                    "\n" +
                    "\n" +
                    "(صفة الرمي): من بعد الزوال تبدأ بالصغرى وهي أبعدهن عن مكة ثم الوسطى ثم جمرة العقبة كل واحدة بسبع حصيات متعاقبات تكبر مع كل حصاة، وتقف بعد الأولى والوسطى تدعو الله مستقبلاً القبلة وتطيل الدعاء وترفع يديك، ولا تقف بعد الكبرى (العقبة).\n" +
                    "\n" +
                    "\n"
            //13

            ,

            "\n" +
                    "\n" +
                    " طواف الوداع: وهو آخر أعمال المناسك إذا أردت الرجوع إلى بلدك، فطف عند سفرك طواف الوداع سبعة أشواط بثيابك. .\n" +
                    "\n"
            //14
,
            "\n" +
                    "\n" +
                    "  ويلزمك الخروج من مكة بعد اتمامك لطواف الورداع، وإلا عليك إعادة الطواف. .\n" +
                    "\n"



    };


    FirebaseAuth fauth;
    FirebaseFirestore fStore;
    boolean Notice=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_hajj);

        hajj_text=findViewById(R.id.hajj_text);
        hajj_text.setTextSize(20);


                index=0;
                hajj_text.setText(items[index]);

        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        DocumentReference otherReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());


        otherReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Notice=documentSnapshot.getBoolean("Notice");
            }
        });

        btn_hajj_next=findViewById(R.id.btn_hajj_next);
        btn_hajj_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<13)
                {

                    index++;

                    hajj_text.setText(items[index]);
                    if(Notice) {
                        if (index == 1) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h1);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 2) {

                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h2);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 3) {

                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h3);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 4) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h4);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 5) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h5);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 6) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h6);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 7) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h7);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 8) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h8);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 9) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h9);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 10) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h10);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 11) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h11);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 12) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h12);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 13) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.h13);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                    }
                }
            }
        });
    }


    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }


}