package com.example.projekat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class IshranaDatabaseHelper  extends SQLiteOpenHelper {

    private static final String DB_NAME = "ishrana"; //ime baze podataka
    private static final int DB_VERSION = 16; //verzija baze podataka

    IshranaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DORUCAK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "IMAGE_RESOURCE_ID INTEGER);");
        insertDorucak(db, "Ovsena kaša", "40gr ovsenih pahuljica\n" +
                "240ml vode\n" +
                "Prstohvat soli\n" +
                "½ kasicice ekstrakta od vanile\n" +
                "¼ kasicice cimeta\n" +
                "Nadev:\n" +
                "1 kasika bademovog putera\n" +
                "1 kasika listica kokosa\n" +
                "1 kasika iseckane crne cokolade\n" +
                "1 kasika meda\n" +
                "Pola banane\n" +
                "Sveze borovnice", R.drawable.ovsena);
        insertDorucak(db, "Omlet sa spanaćem", "4 kom. jaja\n" +
                "50 g feta sira\n" +
                "1 kom. biberа\n" +
                "20 g maslaca\n" +
                "2 kom. mladog luka", R.drawable.kajgana);
        insertDorucak(db, "Smuti sa voćem i semenkama", "1 mango\n" +
                "3 šolje bebi spanaća\n" +
                "1 šolja jagoda\n" +
                "1/2 šolje smrznutih kupina\n" +
                "1/2 šolje smrznutih malina\n" +
                "2 kašike meda\n" +
                "1 šolja bademovog mleka ili kokosovog mleka\n" +
                "semenke, po želji za ukras\n" +
                "čia semenke, po želji za ukras\n" +
                "kokosove pahuljice, po želji za ukras\n" +
                "sveže voće, po želji za ukras", R.drawable.smuti);
        insertDorucak(db, "Dimljeni losos sa jajima", "2 jaja\nDimljeni losos\nRukola", R.drawable.losos);


        db.execSQL("CREATE TABLE RUCAK (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "IMAGE_RESOURCE_ID INTEGER);");
        insertRucak(db, "Piletina sa prosom i semenkama", "400 g belog pilećeg mesa šoljica prosa\n" +
                "300 g ražanog hleba bez kvasca\n" +
                "5 čenova belog luka\n" +
                "kašika suncokreta\n" +
                "kašika susama\n" +
                "kašika mlevenog susama\n" +
                "kašika lana\n" +
                "sok od jednog limuna\n" +
                "maslinovo ulje\n" +
                "himalajska so\n" +
                "mlevena paprika\n" +
                "biber\n" +
                "kurkuma\n" +
                "origano", R.drawable.piletina);
        insertRucak(db, "Povrće sa roštilja", "– 2 mlada kukuruza u klipu\n" +
                "– 1 Iceberg Salat Centar tikvica (seckana na kolutove)\n" +
                "– 1 šolja šampinjona (bez peteljki)\n" +
                "– 1 manji crveni luk (očišćen i iseckan na manje komade)\n" +
                "– 1 crvena paprika (očišćena i iseckana na manje komade)\n" +
                "– 1 zelena paprika (očišćena i iseckana na manje komade)\n" +
                "– 1 žuta paprika (očišćena i iseckana na manje komade)\n" +
                "– ½ šolje maslinovog ulja\n" +
                "– prstohvat soli\n" +
                "– prstohvat bibera\n" +
                "– caciki (tzatziki) umak za serviranje", R.drawable.povrce);
        insertRucak(db, "Pasta sa bundevom, fetom i paradajzom", "– 400 g Iceberg Salat Centar bundeve\n" +
                "– 300 g Iceberg Salat Centar cherry pararadajza\n" +
                "– 200 g feta sira\n" +
                "– 5 kašika maslinovog ulja\n" +
                "– 1 glavica belog luka\n" +
                "– Po ½ kašičice soli, suvih začina i 1 kašika ruzmarina\n" +
                "– Pasta (po izboru)", R.drawable.pasta);
        insertRucak(db, "Salata sa medom", "– 1 manja Iceberg Salat Centar bundeva (seckana na kriške)\n" +
                "– 2 crvena luka (prepolovljena i iseckana na kriške)\n" +
                "– 4 paškanata (seckana na štapiće)\n" +
                "– 3 kašike maslinovog ulja\n" +
                "– 1-2 kašičice organskog meda\n" +
                "– 1 kašičica suncokretovih semenki (opciono)\n" +
                "– 1 šolja baby spanaća\n" +
                "– 2 kašike jabukovog sirćeta\n" +
                "– 1 kašičica Dižon senfa\n" +
                "– so i biber (po ukusu)", R.drawable.salata);

        db.execSQL("CREATE TABLE VECERA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "DESCRIPTION TEXT, " +
                "IMAGE_RESOURCE_ID INTEGER);");
        inserVecera(db, "Brokoli salata", "Brokoli 200g\nŠampinjoni 100g\nBebi spanać", R.drawable.brokoli);
        inserVecera(db, "Salata od kinoe", "– 2 šolje skuvane kinoe\n" +
                "– ⅔ šolje skuvanog kukuruza šećerca\n" +
                "– ⅔ šolje pasterizovanog crvenog pasulja\n" +
                "– 1 glavica Iceberg Salat Centar ljubičastog luka\n" +
                "– 1 crvena paprika\n" +
                "– 3 kašike maslinovog ulja\n" +
                "– 2 čena belog luka\n" +
                "– Sok od 1 limuna Iceberg Salat Centar\n" +
                "– So, biber, peršun (po ukusu)", R.drawable.kinoa);
        inserVecera(db, "Smuti od grejpa i spanaća", "– 1 grejpfrut (oguljen i iseckan na manje komade)\n" +
                "– 1 jabuka (oguljena i iseckana na manje komade)\n" +
                "– 1 šolja Iceberg Salat Centar baby spanaća (sitno seckanog)\n" +
                "– 1 banana (sitno seckana)\n" +
                "– ½ šolje nezaslađenog bademovog mleka\n" +
                "– ½ kašičice svežeg đumbira (sitno seckanog)\n" +
                "– 2 – 3 kockice leda (po želji)", R.drawable.zelenismuti);
    }

    //Ovaj metod se poziva kada baza podataka treba da se nadogradi
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDorucak = "DROP TABLE IF EXISTS dorucak";
        String sqlRucak = "DROP TABLE IF EXISTS rucak";
        String sqlVecera = "DROP TABLE IF EXISTS vecera";

        db.execSQL(sqlRucak);
        db.execSQL(sqlVecera);
        db.execSQL(sqlDorucak);

        onCreate(db);
    }

    private static void insertDorucak(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues dorucakValues = new ContentValues();
        dorucakValues.put("NAME", name);
        dorucakValues.put("DESCRIPTION", description);
        dorucakValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("DORUCAK", null, dorucakValues);
    }

    private static void insertRucak(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues rucakValues = new ContentValues();
        rucakValues.put("NAME", name);
        rucakValues.put("DESCRIPTION", description);
        rucakValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("RUCAK", null, rucakValues);
    }

    private static void inserVecera(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues veceraValues = new ContentValues();
        veceraValues.put("NAME", name);
        veceraValues.put("DESCRIPTION", description);
        veceraValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("VECERA", null, veceraValues);
    }

    Cursor readAllData(){
        String query = "SELECT * FROM DORUCAK";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public ArrayList<Obrok> readDorucak(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM DORUCAK", null);
        ArrayList<Obrok> listaDorucak = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                listaDorucak.add(new Obrok(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaDorucak;
    }

    public ArrayList<Obrok> readRucak(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM RUCAK", null);
        ArrayList<Obrok> listaRucak = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                listaRucak.add(new Obrok(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaRucak;
    }


    public ArrayList<Obrok> readVecera(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM VECERA", null);
        ArrayList<Obrok> listaVecera = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                listaVecera.add(new Obrok(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaVecera;
    }

}
