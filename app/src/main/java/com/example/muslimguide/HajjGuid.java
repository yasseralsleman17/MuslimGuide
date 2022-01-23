package com.example.muslimguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HajjGuid extends AppCompatActivity {


    TextView hajj_text;

    Button btn_hajj_start,btn_hajj_next;

    int index=0;
    String[] items = new String[]{

            "تبدأ من الميقات\n" +
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
                    "ثم ترجع للتلبية العامة: \"لبيك اللهم لبيك...الخ\". حتى تصل إلى البيت الحرام.\n"


            ,


            "توجه إلى المسجد الحرام للطواف\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "عند رؤيتك للبيت كبر وقل: \"اللهم زد هذا البيت تشريفاً وتعظيماً وتكريماً ومهابة وأمناً، وزد من   شرفه وكرمه ممن حجه أو اعتمره تشريفاً وتكريماً وتعظيماً وبِراً\".\n" +
                    "\n" +
                    "\n" +
                    "·اقطع التلبية وتوجه إلى البيت الحرام.\n" +
                    "\n" +
                    "\n" +
                    "·إذا دخلت المسجد الحرام، قدم رجلك اليمنى وقل:\n" +
                    "\"بسم الله والصلاة والسلام على رسول الله، اللهم اغفر لي ذنوبي وافتح لي أبواب رحمتك\".\n" +
                    "أو : \"أعوذ بوجهك العظيم وسلطانك القديم من الشيطان الرجيم\".\n" +
                    "\n" +
                    "\n" +
                    "تقدم إلى الحجر الأسود لتبدأ الطواف منه، استلم الحجر بيدك اليمنى وقبله، فإن شق التقبيل فاستلمه بيدك فقط، وإن شق بيدك فاستلمه بعصا أو غيرها ولا تقبلها، فإن شق الاستلام، فأشر إليه بيدك اليمنى ولا تقبلها.\n" +
                    "\n" +
                    "\n" +
                    "\"بسم الله والصلاة والسلام على رسول الله، اللهم اغفر لي ذنوبي وافتح لي أبواب رحمتك\".\n" +
                    "أو : \"أعوذ بوجهك العظيم وسلطانك القديم من الشيطان الرجيم\".\n" +
                    "\n" +
                    "\n" +
                    "تقدم إلى الحجر الأسود لتبدأ الطواف منه، استلم الحجر بيدك اليمنى وقبله، فإن شق التقبيل فاستلمه بيدك فقط، وإن شق بيدك فاستلمه بعصا أو غيرها ولا تقبلها، فإن شق الاستلام، فأشر إليه بيدك اليمنى ولا تقبلها.\n" +
                    "\n" +
                    "\n" +
                    "·من الأفضل ألا تؤذي المعتمرين في حال الزحام، جاعلاً البيت على يسارك مضطبعاً   بردائك (اجعل كتفك الأيمن مكشوفاً). وكلما وصلت الحجر الأسود أو حاذيته قل: \"بسم الله، الله أكبر. أو \"الله أكبر\" فقط.\n" +
                    "\n" +
                    "\n" +
                    "·ارمل (أسرع قليلاً) في الأشواط الثلاثة الأولى، وامش على مهل في الأشواط الأربعة الباقية، وهذا خاص بطواف القدوم فقط إن تيسر وإلا فإنه يترك مع شدة الزحام.\n" +
                    "\n" +
                    "\n" +
                    "·أدع وقل بين الركنين (الركن اليماني والحجر الأسود): \"ربنا آتنا في الدنيا حسنة وفي الآخرة حسنة وقنا عذاب النار\".\n" +
                    "\n" +
                    "\n" +
                    "وكل مرة تمر فيها بالحجر الأسود قل: \"بسم الله والله أكبر\".\n" +
                    "ولك أن تدعو الله بما تشاء في بقية الطواف وأن تتضرع إليه أو أن تقرأ شيئاً من القرآن..الخ. ولا يلزم دعاء بعينه لكل شوط.\n" +
                    "\n" +
                    "\n" +
                    "وكل مرة تمر فيها بالحجر الأسود قل: \"بسم الله والله أكبر\".\n" +
                    "ولك أن تدعو الله بما تشاء في بقية الطواف وأن تتضرع إليه أو أن تقرأ شيئاً من القرآن..الخ. ولا يلزم دعاء بعينه لكل شوط.\n" +
                    "\n" +
                    "\n" +
                    "·عندما تكمل الأشواط السبعة، توجه إلى مقام إبراهيم واقرأ قوله تعالى: \"واتخذوا من مقام إبراهيم مصلى\" وصل ركعتين خلف المقام قريباً منه إن تيسر لك – أو بعيداً في أي مكان من المسجد. تقرأ بعد الفاتحة \"قل يا أيها الكافرون\" في الركعة الأولى، وتقرأ بعد الفاتحة \"قل هو الله أحد\" في الركعة الثانية، وان قرأت بغيرهما فلا بأس.\n" +
                    "\n" +
                    "\n" +
                    "·اذهب إلى زمزم واشرب منها واحمد الله\n"

            ,

            "اخرج إلى الصفا للسعي\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "·اصعد عليه (وهو الأفضل) حتى ترى الكعبة واستقبلها وارفع يديك وهلل وكبر ثلاثاً، وقل: \"لا إله إلا الله وحده لا شريك له له الملك وله الحمد وهو على كل شيء قدير. لا إله إلا الله وحده أنجز وعده ونصر عبده وهزم الأحزاب وحده\" ثلاث مرات.\n" +
                    "\n" +
                    "\n" +
                    "ثم اقرأ \" إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم\". \n" +
                    "\n" +
                    "\n" +
                    "وهذه تقرأ عند أول شوط فقط، ويفضل أن تبدأ بها قبل الأذكار الأخرى. ثم تدعو بما تحب من الدعاء في هذا الموضع وترفع يديك. \n" +
                    "\n" +
                    "\n" +
                    "ثم انزل باتجاه المروة، وهرول بين العلمين الأخضرين قائلاً: \"رب اغفر وارحم وتجاوز عما تعلم إنك أنت الأعز الأكرم\".\n" +
                    "\n" +
                    "\n" +
                    "وتمشي المشي المعتاد في سعيك قبلهما وبعدهما. (أما المرأة فلا يشرع لها الإسراع). وتدعو أثناء السعي بما تحب وليس لكل شوط دعاء مخصوص. \n" +
                    "\n" +
                    "\n" +
                    "ثم اقرأ \" إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم\". \n" +
                    "\n" +
                    "\n" +
                    "وهذه تقرأ عند أول شوط فقط، ويفضل أن تبدأ بها قبل الأذكار الأخرى. ثم تدعو بما تحب من الدعاء في هذا الموضع وترفع يديك. \n" +
                    "\n" +
                    "\n" +
                    "ثم انزل باتجاه المروة، وهرول بين العلمين الأخضرين قائلاً: \"رب اغفر وارحم وتجاوز عما تعلم إنك أنت الأعز الأكرم\".\n" +
                    "\n" +
                    "\n" +
                    "وتمشي المشي المعتاد في سعيك قبلهما وبعدهما. (أما المرأة فلا يشرع لها الإسراع). وتدعو أثناء السعي بما تحب وليس لكل شوط دعاء مخصوص. \n" +
                    "\n" +
                    "\n" +
                    "·إذا وصلت المروة فافعل كما فعلت على الصفا ما عدا قراءة الآية المذكورة فإنها تقرأ عند الصفا في الشوط الأول فقط. \n" +
                    "\n" +
                    "\n" +
                    "كرر السعي سبعة أشواط.\n" +
                    "(يحسب الذهاب شوطاً والرجوع شوطاً آخر).\n"


            ,


            "الحلق أو التقصير\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "·إذا أكملت السعي، احلق شعرك أو قصره والحلق أفضل (أما إذا كان قدومك مكة قريباً من وقت الحج فالتقصير أفضل لتحلق بقية شعرك في الحج). (أما المرأة فتقصر من كل ظفيرة قدر أنملة).\n" +
                    "\n" +
                    "\n" +
                    "·اخلع إحرامك والبس ثيابك.\n" +
                    "\n" +
                    "\n" +
                    "وبذلك تكون قد أديت عمرة كاملة إن أردتها مستقلة، أو أردتها للحج إن كنت متمتعاً. وأما إن كنت مفرداً للحج أو قارناً، فتنوي الطواف للقدوم – وهو سنة – والسعي للحج – وهو ركن – ثم تبقى على إحرامك ولا تخلعه ولا تحلق ولا تقصر حتى يوم الثامن من ذي الحجة، فتأتي ببقية أعمال الحج.\n"


            ,


            "أعمال يوم الثامن\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "1.    المبيت بمنى هذا اليوم (وهو من وقت غروب الشمس يوم الثامن من ذي الحجة إلى قرب طلوع فجر يوم عرفة).\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "2.    إذا كنت متمتعاً فاحرم بالحج ضحى أو ظهراً من المكان الذي أردت الحج منه، ويستحب لك الغسل والطيب ولبس إزار ورداء أبيضين نظيفين، ثم انو الحج وقل : (( لبيك حجاً))، ثم \"لبيك اللهم لبيك، لبيك لا شريك لك لبيك، إن الحمد والنعمة لك والملك، لا شريك لك\". أما القارن والمفرد فإنه لا يزال على إحرامه السابق، فيبدأ مباشرة بالتلبية: \"لبيك اللهم لبيك...الخ، من صبح ذلك اليوم.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "4.    1. توجه إلى منى وصل فيها الظهر والعصر والمغرب والعشاء، تجعل الرباعية ركعتين والصلاة في وقتها من غير جمع. ثم صل فيها صلاة فجر اليوم التاسع.\n" +
                    "\n" +
                    "\n" +
                    "2. إذا طلعت الشمس فسر إلى عرفة.\n"


            ,


            "أعمال يوم التاسع\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "1. الوقوف بعرفة:\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "هو أهم أركان الحج وقد قال رسول الله صلى الله عليه وسلم: (الحج عرفة). \n" +
                    "\n" +
                    "\n" +
                    "وقته: \n" +
                    "\n" +
                    "\n" +
                    "أ\u200C-الأفضل: من بعد الزوال حتى بعد غروب الشمس.\n" +
                    "\n" +
                    "\n" +
                    "ب\u200C-الجائز: من طلوع شمس يوم التاسع حتى طلوع فجر يوم العاشر.\n" +
                    "\n" +
                    "\n" +
                    "ولو أدركت لحظة في هذا الوقت بعرفة فحجك صحيح، ولكن إن كانت هذه اللحظة قبل غروب الشمس فقط فعليك دم، وإن كانت بعد الغروب فلا شيء عليك، إلا أنه فاتك المبيت بمزدلفة فعليك دم لأجل مزدلفة لا لأجل عرفة.\n" +
                    "\n" +
                    "\n" +
                    "•  توجه إلى عرفة بعد شروق الشمس وصل فيها الظهر والعصر (جمع تقديم) على ركعتين ركعتين بأذان وإقامتين وامكث فيها إلى غروب الشمس وأكثر من الذكر والدعاء هناك، والسنة أن تستقبل القبلة عند الدعاء لا استقبال الجبل ويستحب هذا الدعاء \"لا إله إلا الله وحده لا شريك له له الملك وله الحمد وهو على كل شيء قدير\".\n" +
                    "\n" +
                    "\n" +
                    "وعرفة كلها موقف، ولا يشرع صعود الجبل ويستحب الإكثار من الدعاء والتضرع ولا يشترط أن تكون واقفاً أو تحت الشمس، فلك أن تجلس وتستظل.\n" +
                    "\n" +
                    " \n" +
                    "2. الإفاضة إلى مزدلفة:\n" +
                    "\n" +
                    "\n" +
                    "أ- إذا غربت الشمس، اذهب إلى مزدلفة فإذا وصلتها صل المغرب والعشاء (جمعاً وقصراً بأذان واحد وإقامتين) قبل أن تحط رحلك، وقبل جمع الحصى.\n" +
                    "\n" +
                    "\n" +
                    "ب- بت في مزدلفة وصلّ الفجر في أول وقته وأكثر من الدعاء والذكر حتى الإسفار (المبيت واجب حتى طلوع الفجر والأفضل حتى الإسفار)، ويجوز للضعفاء من الرجال والنساء أن يدفعوا في آخر الليل بعد غياب القمر لتجنب الزحام.\n" +
                    "\n" +
                    "\n" +
                    "ج- التقط سبع حصيات لرمي جمرة العقبة الأولى ومن أي مكان أخذتها جاز.\n" +
                    "\n" +
                    "\n" +
                    "د- اذهب إلى منى قبل طلوع الشمس.\n"



            ,

            "أعمال يوم العاشر\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "1.    يستحب الدعاء بعد الفجر حتى الإسفار.\n" +
                    "\n" +
                    "\n" +
                    "2. توجه إلى منى لرمي جمرة العقبة والنحرأو إلى مكة لطواف الإفاضة، وأما الحلق فيجوز في أي مكان.\n" +
                    "\n" +
                    "\n" +
                    "3. رمي جمرة العقبة: ارم جمرة العقبة (وهي أقرب الجمرات إلى مكة) بسبع حصيات متعاقبات واحدة بعد الأخرى وكبّر مع كل حصاة.\n" +
                    "\n" +
                    "\n" +
                    "4.    ذبح الهدي: أذبح الهدي وكل منه ووزع على الفقراء – الهدي واجب على المتمتع والقارن، ومستحب للمفرد.\n" +
                    "\n" +
                    "\n" +
                    "5. الحلق أو التقصير: احلق شعرك أو قصره، والحلق أفضل (أما المرأة فتقصر من كل ظفيرة قدر أنملة).\n" +
                    "\n" +
                    "\n" +
                    "• إذا رميت وحلقت، فقد حللت التحلل الأول وكذلك لو فعلت اثنين من أربعة: الرمي أو الحلق أو الطواف أو السعي. أما النحر فلا يدخل هنا لأنه لا يجب على جميع الحجاج. وإذا فعلت هذه الأربعة كاملة مع النحر إذا كان واجباً عليك فقد تحللت التحلل الثاني.\n" +
                    "التحلل الأول: (تتحلل من إحرامك ويجوز لك فعل جميع المحظورات إلا النساء من جماع أو ما دونه كالتقبيل ونحوه).\n" +
                    "\n" +
                    "\n" +
                    "التحلل الثاني: (جاز لك جميع المحظورات حتى النساء).\n" +
                    " \n" +
                    "• إذا رميت وحلقت، فقد حللت التحلل الأول وكذلك لو فعلت اثنين من أربعة: الرمي أو الحلق أو الطواف أو السعي. أما النحر فلا يدخل هنا لأنه لا يجب على جميع الحجاج. وإذا فعلت هذه الأربعة كاملة مع النحر إذا كان واجباً عليك فقد تحللت التحلل الثاني.\n" +
                    "\n" +
                    "\n" +
                    "التحلل الأول: (تتحلل من إحرامك ويجوز لك فعل جميع المحظورات إلا النساء من جماع أو ما دونه كالتقبيل ونحوه).\n" +
                    "\n" +
                    "\n" +
                    "التحلل الثاني: (جاز لك جميع المحظورات حتى النساء).\n" +
                    " \n" +
                    "6. طواف الإفاضة:\n" +
                    "انزل إلى مكة وطف طواف الإفاضة (طواف الحج). وإن حللت قبل ذلك، فطف بثيابك.\n" +
                    "\n" +
                    "\n" +
                    "7. تسعى للحج – إن كنت متمتعاً، أو مفرداً أو قارناً ولم تسع قبل ذلك مع طواف القدوم – ويجوز تأخير طواف الإفاضة وسعي الحج إلى يوم الثالث عشر ولكن لا يحل بدونهما.\n" +
                    "\n" +
                    "\n" +
                    "8. المبيت بمنى أيام التشريق: والمقصود بالمبيت أن يدركك الليل – ولو لحظة   منه – وأنت بمنى حتى لو كنت يقظان أو ماشياً ولا يلزمك النوم.\n"


            ,


            "أعمال أيام التشريق 11 ، 12 ، 13\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "1.    رمي الجمرات أيام التشريق:\n" +
                    "\n" +
                    "\n" +
                    "(صفة الرمي): من بعد الزوال تبدأ بالصغرى وهي أبعدهن عن مكة ثم الوسطى ثم جمرة العقبة كل واحدة بسبع حصيات متعاقبات تكبر مع كل حصاة، وتقف بعد الأولى والوسطى تدعو الله مستقبلاً القبلة وتطيل الدعاء وترفع يديك، ولا تقف بعد الكبرى (العقبة).\n" +
                    "\n" +
                    "\n" +
                    "2. المبيت بمنى هذه الليالي، على الصفة المذكورة يوم العاشر.\n" +
                    "\n" +
                    "\n" +
                    "3. إذا أتممت الرمي في اليوم الثاني عشر من ذي الحجة فإن شئت أن تتعجل فاخرج من منى قبل غروب الشمس. أما إذا غربت الشمس، فيلزمك المبيت ليلة الثالث عشر من ذي الحجة ورمي الجمرات الثلاث بعد زوال الشمس.\n" +
                    "\n" +
                    "\n" +
                    "4. طواف الوداع: وهو آخر أعمال المناسك إذا أردت الرجوع إلى بلدك، فطف عند سفرك طواف الوداع سبعة أشواط بثيابك. ويلزمك الخروج من مكة بعد ذلك، وإلا عليك إعادة الطواف. (الحائض والنفساء لا وداع عليهما).\n" +
                    "\n"



            ,  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hajj_guid);


        hajj_text=findViewById(R.id.hajj_text);
        hajj_text.setTextSize(20);
        hajj_text.setText(items[index]);

        btn_hajj_start=findViewById(R.id.btn_hajj_start);
        btn_hajj_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=0;
                hajj_text.setText(items[index]);
            }
        });


        btn_hajj_next=findViewById(R.id.btn_hajj_next);
        btn_hajj_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<7)
                {
                    index++;

                    hajj_text.setText(items[index]);

                }
            }
        });

    }
}