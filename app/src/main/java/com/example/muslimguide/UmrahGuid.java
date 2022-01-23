package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UmrahGuid extends AppCompatActivity {


    TextView umrah_text;

    Button btn_umrah_start,btn_umrah_next;

    int index=0;
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
                     "\n" +
                     "·صل الصلاة المكتوبة إذا حان وقتها، وصل ركعتين سنة الإحرام (وإن لم تصلها فلا حرج).\n" +
                     "بعدها: إذا ركبت السيارة انْو ِ الدخول في النسك\n" +
                     "\n" +
                     "\n" +
                     "ثم – قل – حسب نسكك:\n" +
                     "1- إن كنت تريد العمرة فقط : (لبيك عمرة).\n" +
                     "2- وإن كنت تريد الحج فقط – الإفراد - :( لبيك حجاً)\n" +
                     "3- وإن كنت تريد الحج والعمرة بأفعالهما – التمتع - : (لبيك عمرة متمتعاً بها إلى الحج).\n" +
                     "4- وإن كنت تريد الحج والعمرة بأفعال الحج – القارن -: (لبيك عمرة وحجاً).\n" +
                     "ولا يلزم تكرار هذه الألفاظ ثلاثاً، بل مرة واحدة تكفي.\n" +
                     "\n" +
                     "\n" +
                     "ملاحظات:\n" +
                     "\n" +
                     "\n" +
                     "1. كل نسك من هذه الأنساك له فائدته الخاصة.\n" +
                     "2. بينها فروق في النية والألفاظ والأفعال.\n" +
                     "3. أفضلها: التمتع، ثم الإفراد، ثم القران.\n" +
                     "4. القران تحتاج إليه المرأة إذا أرادت الإحرام متمتعة ولم تستطع أن تنجز عمرتها حتى حاضت. وكذلك من قدم متأخراً حتى خشي فوات الوقوف بعرفة وكذلك من صُدَ عن البيت لأي سبب\n" +
                     "ثم إن خشيت عدم القدرة على المضي في النسك، بسبب مرض أو عمل أو إجراءات نظامية فلتقل:\n" +
                     "\"اللهم محلي حيث حبستني\"\n" +
                     "وأما إن لم تخش شيئاً فلا يشرع لك هذا الاشتراط.\n" +
                     "وفائدته : لو حبست عن النسك جاز لك شرعاً أن تخلع إحرامك وترجع ولا يلزمك شيء. \n" +
                     "\n" +
                     "\n" +
                     "ثم تبدأ بالتلبية:\n" +
                     "\"لبيك اللهم لبيك، لبيك لا شريك لك لبيك. إن الحمد والنعمة لك والملك، لا شريك لك\"\n" +
                     "يجهر الرجل بهذه التلبية. وأما المرأة فتقولها سراً.\n" +
                     "ولا يشرع التلبية الجماعية، وإنما يلبي كل محرم وحده ويستمر بهذه التلبية حتى يصل إلى البيت الحرام.\n" +
                     "\n" +
                     "\n" +
                     "وأما الدعاء: \"اللهم أني أريد العمرة، فيسرها لي وتقبلها مني، لبيك اللهم لبيك، لبيك لا شريك لك لبيك، إن الحمد والنعمة لك والملك، لا شريك لك\"، فلا يلزم دعاء بعينه، بل يدعو بما أراد. \n" +
                     "وكذلك الصلاة على النبي صلى الله عليه وسلم لم ترد في هذا الموضع. وكذلك \"اللهم إني أسألك رضاك والجنة وأعوذ بك من سخطك والنار\".\n" +
                     "\n" +
                     "\n" +
                     "يشرع في الطريق: أن تكبر الله كلما صعدت مرتفعاً، وأن تسبح كلما هبطت وادياً.\n" +
                     "ثم ترجع للتلبية العامة: \"لبيك اللهم لبيك...الخ\". حتى تصل إلى البيت الحرام.\n" +
                     "\n" +
                     " \n" +
                     "\n"

            ,

           "الإحرام\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "هو نية الدخول في العمرة\n" +
                   "\n" +
                   "\n" +
                   "يستحب أن يتلفظ المعتمر بقول (لبيك عمرة) عند إحرامه.\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   " يُحرم الذكر في إزار ورداء من غير المخيط - أي غير المفصل على مقدار العضو، كالفنيلة والشراب والسروال ...الخ. ويستحب أن يكون أبيضين. يستحب الاغتسال والطيب والتنظف قبل عقد نية الإحرام.\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "ليس للإحرام ركعتان تسميان (ركعتي الإحرام) لكن لو صادف وقت حضور صلاة فريضة فأنه يحرم بعدها لفعله صلى الله عليه وسلم.\n" +
                   "\n" +
                   "\n" +
                   "تسن التلبية بعد الإحرام وهي قول: \n" +
                   "\n" +
                   "\n" +
                   "(لبيك اللهم لبيك، لبيك لا شريك لك لبيك، إن الحمد والنعمة لك والملك لا شريك لك).\n" +
                   "\n" +
                   "\n" +
                   "ويرفع بها الرجال أصواتهم، أما النساء فيخفض أصواتهن بها. ويتوقف المعتمر عند التلبية عند ابتدائه الطواف.\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "يجوز خلع لباس الإحرام وتغييره إذا اتسخ مثلاَ. ويجوز للمحرم لبس الإحرام في بيته قبل سفره ولكن لا يعقد نية الإحرام إلا عند الميقات. ليس للمرأة لباس معين للإحرام كالأسود أو الأخضر كما يعتقد البعض. \n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "لا يجوز للمرأة المحرمة أن تلبس القفازين أو النقاب لأنهما مفصلان على مقدار العضو لقوله صلى الله عليه وسلم (لا تنتقب المحرمة ولا تلبس القفازين) رواه البخاري. \n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "ولكنها تستر وجهها ويديها عن الأجانب بغير القفازين والنقاب.\n" +
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
                    "\n" +
                    "\n" +
                    "يسن أن يضطبع المعتمر في طوافه كله. والاضطباع هو أن يجعل وسط ردائه تحت كتفه الأيمن وطرفيه على كتفه الأيسر. يزيل المعتمر الاضطباع إذا فرغ من طوافه. يسن لمن يطوف أن يستلم الحجر الأسود (أي يلمسه بيده) ويقبله عند مروره به، فإن لم يستطع استلمه بيده وقبلها، فإن لم يستطع استلمه بشيء معه (كالعصا وما شابهها). وقَبَّل ذلك الشيء، فإن لم يستطع أشار إليه بيده ولا يقبلها.\n" +
                    "\n" +
                    "\n" +
                    "يسن لمن يطوف أن يستلم الركن اليماني بيده ولا يقبله، فإن لم يستطع استلامه بسبب الزحام لم يشر إليه. \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "يسن لمن يطوف أن يكبر عند استلامه للحجر الأسود أو عند الإشارة إليه. لا يشرع لمن يطوف أن يقبل أو يستلم أو يشير إلى الركنين الشاميين لأنه صلى الله عليه وسلم لم يفعل ذلك بهما.  يسن لمن يطوف أن يقول بين الركن اليماني والحجر الأسود: \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "(ربنا آتنا في الدنيا حسنة وفي الآخرة حسنة وقنا عذاب النار).\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "ليس هناك ذكر أو دعاء خاص بكل شوط من أشواط الطواف كما يعتقد البعض. بل يجوز أن يقرأ المسلم القرآن في طوافه، أو يقول ما شاء من الأدعية النبوية الصحيحة. \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "تشترط الطهارة للطواف. أما إذا انتقض وضوء المسلم وهو يطوف فإنه يتوضأ ثم يعيد الطواف كله من جديد. إذا أقيمت صلاة الفريضة وهو يطوف فإنه يصليها مع المسلمين ثم يكمل ما بقي من طوافه. لا يجوز للمرأة الحائض أن تطوف حتى تطهر من حيضها. \n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "يجوز للمرأة أن تأكل حبوباً تؤخر الحيض عنها حتى تتم عمرتها بشرط ألا تكون مضرة بصحتها.  من شك في عدد أشواط الطواف التي طافها فإنه يرجح الأقل، ثم يكمل.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "                 الصلاة عند المقام\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    " يسن للمعتمر عند توجهه للصلاة عند المقام أن يتلو قوله تعالى: (واتخذوا من مقام إبراهيم مصلى). \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "يسن أن يصلي المعتمر ركعتين خلف المقام بعد طوافه، يقرأ في الركعة الأولى سورة (الكافرون) وفي الركعة الثانية سورة (الإخلاص).\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "إذا لم يستطع أن يصلي الركعتين خلف المقام بسبب الزحام فإنه يصليها في مكان آخر من المسجد الحرام. \n" +
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
                   "\n" +
                   " \n" +
                   "\n" +
                   "يسن أن يرقى المعتمر على الصفا حتى يرى الكعبة فيستقبلها ويرفع يديه كما يرفعها عند الدعاء قائلاً:\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "الله أكبر، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، لا إله إلا الله وحده لا شريك له أنجز وعده ونصر عبده وهزم الأحزاب وحده.\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "ثم يدعو بما شاء من الدعاء ثم يعيد الذكر السابق، ثم يدعو بما شاء، ثم يعيد الذكر السابق مرة ثالثة، ثم يسعى إلى المروة.\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   " ويسن أن يرفع صوته بالتكبير والذكر السابق ويُسر صوته بالدعاء. يفعل المعتمر على المروة مثلما فعل على الصفا من التكبير (3مرات) والذكر السابق (3 مرات) والدعاء بين الأذكار (مرتين) مع رفع يديه متوجهاً للكعبة. \n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "يسن إذا وصل الساعي بين العلمين الأخضرين أن يُسرع في المشي بشرط أن لا يضايق غيره من الساعين، أما في بقية المسعى فإنه يمشي مشياً عادياً.  لا يشترط أن يرقى الساعي على أعلى الصفا والمروة، بل لو لمست رجلاه بداية ارتفاعها فهو جائز، ولكن السنة كما سبق أن يرقى عليهما حتى يرى الكعبة إن استطاع.\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   " لا تشترط الطهارة للسعي، فلو سعى وهو غير متوضئ جاز ذلك، ولكن الأفضل أن يكون على وضوء. لا يوجد ذكر أو دعاء خاص بالسعي، فلو قرأ القرآن أو ذكر الله أودعاه بما يتيسر فهو جائز. إذا أقيمت الصلاة وهو يسعى فإنه يصلي مع الجماعة في المسعى ثم يكمل سعيه. \n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "لا يضطبع المعتمر أثناء السعي بل يكون إحرامه على كتفيه. يجب على المعتمر غض بصره عما قد يفسد عمرته.\n" +
                   "\n"


            ,

           " حلق الشعر أو تقصيره\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "حلق شعر الرأس أو تقصيره من واجبات العمرة. حلق شعر الرأس أفضل من تقصيره. \n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "لأنه صلى الله عليه وسلم دعا للمحلقين ثلاثاً ودعا للمقصرين مرة واحدة. \n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "يجب أن يستوعب التقصير جميع أنحاء الرأس، فلا يكفي أن يقصر جهة ويترك أخرى.\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "لا يجوز للمرأة أن تحلق شعر رأسها لقوله صلى الله عليه وسلم: \n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "ليس على النساء حلق إنما على النساء التقصير.\n" +
                   "\n" +
                   " \n" +
                   "\n" +
                   "صحيح أبي داود (174).\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "ولكن تقصره، وذلك بأن تقص من كل ضفيرة من شعرها قدر رأس الأصبع. بعد الحلق أو التقصير يتحلل المعتمر من إحرامه وبه تنتهي عمرته. إذا نسي المعتمر أن يحلق شعر رأسه أو يقصره ثم خلع إحرامه فانه متى تذكر ذلك. \n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "\n" +
                   "ولو في بلده فانه يلبس إحرامه ويحلق شعر رأسه أو يقصره، ولا شيء عليه لأنه ناسي والله أعلم.\n" +
                   "\n" +
                   " \n"
             };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umrah_guid);


        umrah_text=findViewById(R.id.umrah_text);
        umrah_text.setTextSize(20);
        umrah_text.setText(items[index]);

        btn_umrah_start=findViewById(R.id.btn_umrah_start);
        btn_umrah_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=0;
                umrah_text.setText(items[index]);
            }
        });


        btn_umrah_next=findViewById(R.id.btn_umrah_next);
        btn_umrah_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<4)
                {
                    index++;

                    umrah_text.setText(items[index]);

                }
            }
        });

    }
}