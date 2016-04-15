package com.example.i043113.lego;

/**
 * Created by i043113 on 4/9/16.
 */
public class Missions {

    private static Mission[] missions;

    public static Mission[] getMissions() {
        if (missions == null) {
            loadMissions();
        }
        return missions;
    }

    private static void loadMissions() {
        missions = new Mission[] {
                new Mission("Чистене на морето", new String[]{"не", "да"}, 20,0, R.drawable.more),
                new Mission("Кула", new String[]{"0 ", "1 ", "2 ", "3 ", "4 "}, 15,1, R.drawable.kula),
                new Mission("Фабрика", new String[]{"не", "да"}, 40,0, R.drawable.fabrika),
                new Mission("Събиране", new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12", "13", "14", "15", "16"}, 2,4, R.drawable.baza),
                new Mission("Неразделно събиране", new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12", "13", "14", "15", "16"}, 5,0, R.drawable.smetishte),
                new Mission("Разделно събиране на пластмаса", new String[]{"0 ", "1 ", "2 ", "3 ", "4 ", "5 ", "6 "}, 13,0, R.drawable.plastmasa),
                new Mission("Разделно събиране на хартия", new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, 10, R.drawable.hartiq),
                new Mission("Филтриране", new String[]{"не", "да"}, 70, R.drawable.filtyr),
                new Mission("Изолиране", new String[]{"                     нищо", "             изолация", "пълна изолация"}, 40, R.drawable.izolator),
                new Mission("Титан", new String[]{"не", "да"}, 30, R.drawable.titan),
                new Mission("Наказание", new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12", "13", "14", "15", "16"}, -10, R.drawable.penalty),
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