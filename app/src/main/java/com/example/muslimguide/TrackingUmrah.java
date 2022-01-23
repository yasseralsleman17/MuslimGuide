package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class TrackingUmrah extends AppCompatActivity {

    TextView umrah_text;

    Button btn_umrah_next;
    MediaPlayer mp;

    int index = 0;
    String[] items = new String[]{

            "\n" +
                    "                   تبدأ من الميقات\n" +
                    "\n" +
                    "\n" +
                    "·تًجرّد من الثياب، واغتسل كما تغتسل من الجنابة – إن تيسر لك – وتطيب بأطيب ما تجده من دهن عود أو غيره في رأسك ولحيتك، ولا يضر بقاء ذلك بعد الإحرام، ولكن لا تطيب ثياب الإحرام.\n" +
                    "\n" +
                    "\n" +
                    "·البس ثياب الإحرام (إزاراً ورداءً) ولف الرداء على كتفيك ولا تخرج الكتف الأيمن إلا في الطواف بجميع أنواعه (هذا للرجل). (أما المرأة) فتحرم في ملابسها العادية التي ليس فيها زينة ولا شهرة ولا تلزم بلون معين.\n" +
                    "\n" +
                    "\n"
            ,
            "الطواف              \n" +
                    "\n" +
                    "           \n" +
                    "\n" +
                    "الطواف سبعة أشواط على الكعبة يبدأ كل شوط من أمام الحجر الأسود وينتهي به. يجعل المعتمر الكعبة عن يساره أثناء طوافه. \n" +
                    "\n" +
                    "\n" +
                    "يسن أن يرمل المعتمر في الأشواط الثلاثة الأولى، والرَمَل هو مسارعة المشي مع تقارب الخطوات. \n" +
                    "\n" +
                    "\n" +
                    "\n"
            ,

            " \n" +
                    "\n" +
                    "                 الصلاة عند المقام\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " يسن للمعتمر عند توجهه للصلاة عند المقام أن يتلو قوله تعالى: (واتخذوا من مقام إبراهيم مصلى). \n" +
                    "\n" +
                    "\n"
            ,



            "\n" +
                    "\n" +
                    "يسن عند فراغه من الركعتين أن يشرب من ماء زمزم ثم يذهب ليستلم الحجر الأسود إذا استطاع ذلك. ثم يتجه إلى الصفا ليبدأ سعيه.\n" +
                    "\n" +
                    "\n" +
                    "\n"
            ,

            "   السعي\n" +
                    "\n" +
                    "\n" +
                    "السعي سبعة أشواط بين الصفا والمروة يبدأ من الصفا وينتهي بالمروة. يسن عند قربه من الصفا في بداية الشوط الأول أن يقرأ قوله تعالى: \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "إِنَّ الصَّفَا وَالْمَرْوَةَ مِنْ شَعَائِرِ اللَّهِ فَمَنْ حَجَّ الْبَيْتَ أَوْ اعْتَمَرَ فَلَا جُنَاحَ عَلَيْهِ أَنْ يَطَّوَّفَ بِهِمَا وَمَنْ تَطَوَّعَ خَيْرًا فَإِنَّ اللَّهَ شَاكِرٌ عَلِيمٌ.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "ثم يقول بعدها (أبدأ بما بدأ الله به) ولا يقول هذا إلا في بداية الشوط الأول من السعي. \n" +
                    "\n"
            ,
            " حلق الشعر أو تقصيره\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "حلق شعر الرأس أو تقصيره من واجبات العمرة. حلق شعر الرأس أفضل من تقصيره. \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "لأنه صلى الله عليه وسلم دعا للمحلقين ثلاثاً ودعا للمقصرين مرة واحدة. \n" +
                    "\n" +
                    "\n"
            ,
"تقيل الله طاعتكم"



    };
    FirebaseAuth fauth;
    FirebaseFirestore fStore;
    boolean Notice=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_umrah);

        umrah_text=findViewById(R.id.umrah_text);
        umrah_text.setTextSize(20);


        index=0;
        umrah_text.setText(items[index]);
        fauth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        DocumentReference otherReference = fStore.collection("User").document(fauth.getCurrentUser().getUid());


        otherReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Notice=documentSnapshot.getBoolean("Notice");
            }
        });


        btn_umrah_next=findViewById(R.id.btn_umrah_next);
        btn_umrah_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<6)
                {
                    index++;
                    umrah_text.setText(items[index]);
                    if(Notice) {
                        if (index == 1) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a2);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 2) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a3);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 3) {

                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a4);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();
                        }
                        if (index == 4) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a5);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 5) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a6);
                            mp.setLooping(false);
                            mp.seekTo(0);
                            mp.start();

                        }
                        if (index == 6) {
                            stopPlaying();
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.a7);
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