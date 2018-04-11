package com.robotikazabulgaria;

public class        Missions {

    private static Mission[] missions;

    public static Mission[] getMissions() {
        if (missions == null) {
            loadMissions();
        }
        return missions;
    }

    public static void  reset(){
        loadMissions();
    }


    private static void loadMissions() {
        missions = new Mission[] {
                new DifSpinnerMission("Шамандура",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,20,60}, R.drawable.izolator),
                new DifSpinnerMission("Батерии",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,30,50}, R.drawable.izolator),
                new CheckBoxMission("Цунами", 20,0, R.drawable.more),
                new CheckBoxMission("Активиране на пречиствателя", 10,0, R.drawable.more),
                new DifSpinnerMission("Пречистване",new String[]{"няма","фаза1", "фаза2","фаза3"}, new Integer[]{0,30,50,80}, R.drawable.izolator),
                new CheckBoxMission("Спондж Боби", 30,0, R.drawable.more),
                new ExtraSpinnerMission("573e5401d50551814c0de29e", "Център за обработка на данни", 10, 7,0, R.drawable.kula),
                new DifSpinnerMission("Боцкало",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,50,70}, R.drawable.izolator),
                new DifSpinnerMission("Фар",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,50,80}, R.drawable.izolator),
                new ExtraSpinnerMission("573e5401d50551814c0de29e", "Кладенци", 10, 5,0, R.drawable.kula),
                new AnimalsMission("Пречистена вода в базата", 3, 10, R.drawable.smetishte),
                new AnimalsMission("Пречистена вода в резерва", 3, 20, R.drawable.smetishte),
                new DifSpinnerMission("Воден резерв",new String[]{"няма","фаза1", "фаза2","фаза3"}, new Integer[]{0,40,70,120}, R.drawable.izolator),
                new CheckBoxMission("Финал", 30,0, R.drawable.more),
                new ExtraSpinnerMission("Наказание", 10, -15, R.drawable.penalty)
                /*new FishMission("Аквариум без база", 5, 13, R.drawable.smetishte),
                new FishMission("Аквариум с база", 5, 5, R.drawable.smetishte),
                new CheckBoxMission("Клопка", 25,0, R.drawable.more),
                new CheckBoxMission("Хищник", 35,0, R.drawable.more),
                new CheckBoxMission("Горила", 80,0, R.drawable.more),
                new SpinnerMission("Свобода", new String[]{"няма","фаза1", "фаза2"}, 20, R.drawable.izolator),
                new SpinnerMission("Нефтена платформа", new String[]{"няма","фаза1", "фаза2"}, 25, R.drawable.izolator),
                new AnimalsMission("Животни в базата", 16, 10, R.drawable.smetishte),
                new AnimalsMission("Животни в зоо", 16, 13, R.drawable.smetishte),
                new CheckBoxMission("Семейство", 40,0, R.drawable.more),
                new DifSpinnerMission("Лъв",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,20,35}, R.drawable.izolator),

                new DifSpinnerMission("Мечка",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,10,50}, R.drawable.izolator),
                new DifSpinnerMission("Стара планина",new String[]{"няма","фаза1", "фаза2"}, new Integer[]{0,20,50}, R.drawable.izolator),
                new CheckBoxMission("Край", 25,0, R.drawable.more),
                new ExtraSpinnerMission("Наказание", 10, -10, R.drawable.penalty)
                //стара,мечка,жираф,лъв
                new ExtraSpinnerMission("573e5401d50551814c0de29e", "Кула", 4, 15,1, R.drawable.kula),
                new CheckBoxMission("573e5401d50551814c0de29f", "Фабрика", 40,0, R.drawable.fabrika),
                new FishMission("573e5401d50551814c0de2a0", "Събиране", 18, 2, 4, R.drawable.baza),
                new FishMission("573e5401d50551814c0de2a1", "Неразделно събиране", 18, 5, R.drawable.smetishte),
                new FishMission("573e5401d50551814c0de2a2", "Разделно събиране на пластмаса", 7, 13, R.drawable.plastmasa),
                new FishMission("573e5401d50551814c0de2a3", "Разделно събиране на хартия", 11, 10, R.drawable.hartiq),
                new CheckBoxMission("573e5401d50551814c0de2a4", "Филтриране", 70, R.drawable.filtyr),
                new SpinnerMission("573e5401d50551814c0de2a5", "Изолиране", new String[]{"нищо", "изолация", "пълна изолация"}, 40, R.drawable.izolator),
                new CheckBoxMission("573e5401d50551814c0de2a6", "Титан", 30, R.drawable.titan),
                */
        };
    }
}
// drugoto e scoring reda moje malko da se poigrae da se barne mhm
// vij scoring reda i spinner centriranetog
// az shte si poigraq s title bara
//ok i kakvo mislish kakvo ni trqbva emi za sega mai e dostachno to vsichko moze da se barne ama za sega sstava
//mi zna4i i kartinki tr da si namislim
// prati edin screenshot na marin s problema sys strelkata na spinnera nad score-a ok a az gledah che na starata versiq koqto mi e na telo go nqma toq problem
//kakvo napravi emi sq ve4e e zaradi teskta ne e ot teksta hmmmmmmm nqmam gram ideq emi i az moze da probvame da mu slozimedno 10 i da vidim dali shte se pravi
//tocho tva si misleh davaida opravi se chakaii taka kak e mi struvaa mi sse pak ekrivo ama veche moje i dane dovijdam :D abe mai sa ravniemm ok
//da moje da syszadesh mission po 2 na4ina, ediniq da podadesh laststate, drugiq da ne podadesh,  i
//pratih ti edin link za tova, razcykai go kato namerish vreme nqkoi pyt ok
// i  kato ne podadesh po default shte e 0   tva e qko(y)