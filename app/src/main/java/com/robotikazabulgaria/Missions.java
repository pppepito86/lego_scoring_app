package com.robotikazabulgaria;

public class Missions {

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
                new CheckBoxMission("573e5401d50551814c0de29d", "Чистене на морето", 20,0, R.drawable.more),
                new ExtraSpinnerMission("573e5401d50551814c0de29e", "Кула", 4, 15,1, R.drawable.kula),
                new CheckBoxMission("573e5401d50551814c0de29f", "Фабрика", 40,0, R.drawable.fabrika),
                new GarbageMission("573e5401d50551814c0de2a0", "Събиране", 18, 2, 4, R.drawable.baza),
                new GarbageMission("573e5401d50551814c0de2a1", "Неразделно събиране", 18, 5, R.drawable.smetishte),
                new GarbageMission("573e5401d50551814c0de2a2", "Разделно събиране на пластмаса", 7, 13, R.drawable.plastmasa),
                new GarbageMission("573e5401d50551814c0de2a3", "Разделно събиране на хартия", 11, 10, R.drawable.hartiq),
                new CheckBoxMission("573e5401d50551814c0de2a4", "Филтриране", 70, R.drawable.filtyr),
                new SpinnerMission("573e5401d50551814c0de2a5", "Изолиране", new String[]{"нищо", "изолация", "пълна изолация"}, 40, R.drawable.izolator),
                new CheckBoxMission("573e5401d50551814c0de2a6", "Титан", 30, R.drawable.titan),
                new ExtraSpinnerMission("573e5401d50551814c0de2a7", "Наказание", 10, -10, R.drawable.penalty),
        };
    }
}
// drugoto e scoring reda moje malko da se poigrae da se barne mhm
// vij scoring reda i spinner centriraneto
// az shte si poigraq s title bara
//ok i kakvo mislish kakvo ni trqbva emi za sega mai e dostachno to vsichko moze da se barne ama za sega sstava
//mi zna4i i kartinki tr da si namislim
// prati edin screenshot na marin s problema sys strelkata na spinnera nad score-a ok a az gledah che na starata versiq koqto mi e na telo go nqma toq problem
//kakvo napravi emi sq ve4e e zaradi teskta ne e ot teksta hmmmmmmm nqmam gram ideq emi i az moze da probvame da mu slozimedno 10 i da vidim dali shte se pravi
//tocho tva si misleh davaida opravi se chakaii taka kak e mi struvaa mi sse pak ekrivo ama veche moje i dane dovijdam :D abe mai sa ravniemm ok
//da moje da syszadesh mission po 2 na4ina, ediniq da podadesh laststate, drugiq da ne podadesh,  i
//pratih ti edin link za tova, razcykai go kato namerish vreme nqkoi pyt ok
// i  kato ne podadesh po default shte e 0   tva e qko(y)