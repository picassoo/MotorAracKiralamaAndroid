package com.example.muhammmedal.yazillim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MUHAMMMED ALİ on 23.05.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "motorarac.db";
    private static final int DATABASE_VERSION = 3;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public static final String TABLE_ARAC = "arac_tablosu";
    public static final String COLUMN_ARAC_ID = "id_arac";
    public static final String COLUMN_ARAC_PLAKA = "plaka_arac";
    public static final String COLUMN_ARAC_MARKA = "marka_arac";
    public static final String COLUMN_ARAC_MODEL = "model_arac";
    public static final String COLUMN_ARAC_SIRKET = "sirket_arac";
    public static final String COLUMN_ID_ARAC_SIRKET ="idsirketarac";


    private static final String DATABASE_CREATE_ARAC = "create table "
            + TABLE_ARAC + "("
            + COLUMN_ARAC_ID + " integer primary key autoincrement, "
            + COLUMN_ARAC_PLAKA +" text, "
            + COLUMN_ARAC_MARKA + " text not null, "
            + COLUMN_ARAC_MODEL + " text not null, "
            + COLUMN_ARAC_SIRKET + " text, "
            + COLUMN_ID_ARAC_SIRKET +" integer "
            + "); ";


    public static final String TABLE_YAKIT= "yakıt_tablosu";
    public static final String COLUMN_YAKIT_ID = "id_yakıt";
    public static final String COLUMN_YAKIT_TARIH = "tarih_yakıt";
    public static final String COLUMN_YAKIT_LITRE = "litre_yakıt";
    public static final String COLUMN_YAKIT_FIYAT = "fiyat_yakıt";

    private static final String DATABASE_CREATE_YAKIT = "create table "
            + TABLE_YAKIT + "("
            + COLUMN_YAKIT_ID + " integer primary key autoincrement, "
            + COLUMN_YAKIT_TARIH +" DATE not null, "
            + COLUMN_YAKIT_LITRE+ " decimal not null, "
            + COLUMN_YAKIT_FIYAT + " decimal not null"
            + "); ";

    public static final String TABLE_KM= "km_tablosu";
    public static final String COLUMN_KM_ID = "id_km";
    public static final String COLUMN_KM_TARIH = "tarih_km";
    public static final String COLUMN_KM_MESAFE = "mesafe_km";

    private static final String DATABASE_CREATE_KM = "create table "
            + TABLE_KM + "("
            + COLUMN_KM_ID + " integer primary key autoincrement, "
            + COLUMN_KM_TARIH +" DATE not null, "
            + COLUMN_KM_MESAFE+ " decimal not null"
            + "); ";


    public static final String TABLE_BAKIM= "bakım_tablosu";
    public static final String COLUMN_BAKIM_ID = "id_bakım";
    public static final String COLUMN_BAKIM_TARIH = "tarih_bakım";
    public static final String COLUMN_BAKIM_TUR = "tur_bakım";
    public static final String COLUMN_BAKIM_ACIKLAMA = "acıklama_bakım";

    private static final String DATABASE_CREATE_BAKIM = "create table "
            + TABLE_BAKIM + "("
            + COLUMN_BAKIM_ID + " integer primary key autoincrement, "
            + COLUMN_BAKIM_TARIH +" DATE not null, "
            + COLUMN_BAKIM_TUR+ " text not null,"
            + COLUMN_BAKIM_ACIKLAMA+" text not null"
            + "); ";


    public static final String TABLE_PARCA= "parca_tablosu";
    public static final String COLUMN_PARCA_ID = "id_parca";
    public static final String COLUMN_PARCA_TARIH = "tarih_parca";
    public static final String COLUMN_PARCA_PARCA = "parca_parca";
    public static final String COLUMN_PARCA_ACIKLAMA = "acıklama_parca";

    private static final String DATABASE_CREATE_PARCA= "create table "
            + TABLE_PARCA + "("
            + COLUMN_PARCA_ID + " integer primary key autoincrement, "
            + COLUMN_PARCA_TARIH +" DATE not null, "
            + COLUMN_PARCA_PARCA+ " text not null,"
            + COLUMN_PARCA_ACIKLAMA+" text not null"
            + "); ";

    public static final String TABLE_YAKIT_GECIS= "yakıt_gecis_tablosu";
    public static final String COLUMN_ID_YAKIT_GECIS = "id_aracyakıt_gecis";
    public static final String COLUMN_ARAC_ID_YAKIT_GECIS = "id_arac_yakıt_gecis";
    public static final String COLUMN_YAKIT_ID_YAKIT_GECIS = "id_yakıt_gecis";

    private static final String DATABASE_CREATE_YAKIT_GECIS= "create table "
            + TABLE_YAKIT_GECIS + "("
            + COLUMN_ID_YAKIT_GECIS + " integer primary key autoincrement, "
            + COLUMN_ARAC_ID_YAKIT_GECIS +" integer not null, "
            + COLUMN_YAKIT_ID_YAKIT_GECIS+ " integer not null"
            + "); ";

    public static final String TABLE_BAKIM_GECIS= "bakim_gecis_tablosu";
    public static final String COLUMN_ID_BAKIM_GECIS = "id_aracbakım_gecis";
    public static final String COLUMN_ARAC_ID_BAKIM_GECIS = "id_arac_bakım_gecis";
    public static final String COLUMN_BAKIM_ID_BAKIM_GECIS = "id_bakım_gecis";

    private static final String DATABASE_CREATE_BAKIM_GECIS= "create table "
            + TABLE_BAKIM_GECIS + "("
            + COLUMN_ID_BAKIM_GECIS + " integer primary key autoincrement, "
            + COLUMN_ARAC_ID_BAKIM_GECIS +" integer not null, "
            + COLUMN_BAKIM_ID_BAKIM_GECIS+ " integer not null"
            + "); ";

    public static final String TABLE_PARCA_GECIS= "parca_gecis_tablosu";
    public static final String COLUMN_ID_PARCA_GECIS = "id_aracparca_gecis";
    public static final String COLUMN_ARAC_ID_PARCA_GECIS = "id_arac_parca_gecis";
    public static final String COLUMN_PARCA_ID_PARCA_GECIS = "id_parca_gecis";

    private static final String DATABASE_CREATE_PARCA_GECIS= "create table "
            + TABLE_PARCA_GECIS + "("
            + COLUMN_ID_PARCA_GECIS + " integer primary key autoincrement, "
            + COLUMN_ARAC_ID_PARCA_GECIS +" integer not null, "
            + COLUMN_PARCA_ID_PARCA_GECIS+ " integer not null"
            + "); ";


    public static final String TABLE_KM_GECIS= "km_gecis_tablosu";
    public static final String COLUMN_ID_KM_GECIS = "id_arackm_gecis";
    public static final String COLUMN_ARAC_ID_KM_GECIS = "id_arac_km_gecis";
    public static final String COLUMN_KM_ID_KM_GECIS = "id_km_gecis";

    private static final String DATABASE_CREATE_KM_GECIS= "create table "
            + TABLE_KM_GECIS + "("
            + COLUMN_ID_KM_GECIS + " integer primary key autoincrement, "
            + COLUMN_ARAC_ID_KM_GECIS +" integer not null, "
            + COLUMN_KM_ID_KM_GECIS+ " integer not null"
            + "); ";

    public static final String TABLE_SIRKET= "sirket_tablosu";
    public static final String COLUMN_ID_SIRKET = "id_sirket";
    public static final String COLUMN_AD_SIRKET = "ad_sirket";
    public static final String COLUMN_KREDI_SIRKET = "kredi_sirket";

    private static final String DATABASE_CREATE_SIRKET= "create table "
            + TABLE_SIRKET + "("
            + COLUMN_ID_SIRKET + " integer primary key autoincrement, "
            + COLUMN_AD_SIRKET +" text not null, "
            + COLUMN_KREDI_SIRKET+ " integer not null"
            + "); ";

    public static final String TABLE_KIRALA= "kirala_tablosu";
    public static final String COLUMN_ID_KIRALA = "id_kirala";
    public static final String COLUMN_ID_ARAC_KIRALA = "ıd_arac_kirala";
    public static final String COLUMN_ID_SIRKET_KIRALA = "id_sirket_kirala";

    private static final String DATABASE_CREATE_KIRALA= "create table "
            + TABLE_KIRALA + "("
            + COLUMN_ID_KIRALA + " integer primary key autoincrement, "
            + COLUMN_ID_ARAC_KIRALA +" integer not null, "
            + COLUMN_ID_SIRKET_KIRALA+ " integer not null"
            + "); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_ARAC);
        db.execSQL(DATABASE_CREATE_BAKIM);
        db.execSQL(DATABASE_CREATE_KM);
        db.execSQL(DATABASE_CREATE_PARCA);
        db.execSQL(DATABASE_CREATE_YAKIT);
        db.execSQL(DATABASE_CREATE_BAKIM_GECIS);
        db.execSQL(DATABASE_CREATE_KM_GECIS);
        db.execSQL(DATABASE_CREATE_PARCA_GECIS);
        db.execSQL(DATABASE_CREATE_YAKIT_GECIS);
        db.execSQL(DATABASE_CREATE_SIRKET);
        db.execSQL(DATABASE_CREATE_KIRALA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARCA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BAKIM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_YAKIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARCA_GECIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BAKIM_GECIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KM_GECIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_YAKIT_GECIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARAC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SIRKET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KIRALA);
        // create new tables
        onCreate(db);
    }

    public boolean insertArac ( String marka, String model, String plaka,String malsahibi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (malsahibi.equals("sirket")) contentValues.put(COLUMN_ID_ARAC_SIRKET, -1);
        else if(checkMalSahibi(malsahibi)==false) return false;
        else{
            SQLiteDatabase bd = this.getReadableDatabase();
            Cursor res =  bd.rawQuery( "select * from "+TABLE_SIRKET+" where "+COLUMN_AD_SIRKET +"= '"+malsahibi+"'", null );
            res.moveToFirst();
            contentValues.put(COLUMN_ID_ARAC_SIRKET, res.getString(res.getColumnIndex(COLUMN_ID_SIRKET)));
        }
        contentValues.put(COLUMN_ARAC_MARKA,marka);
        contentValues.put(COLUMN_ARAC_MODEL,model);
        contentValues.put(COLUMN_ARAC_PLAKA,plaka);
        contentValues.put(COLUMN_ARAC_SIRKET, malsahibi);
        db.insert(TABLE_ARAC,null,contentValues);

        return true;
    }

    public String insertBakım (Date date, String aciklama, String tur) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BAKIM_TARIH, sdf.format(date));
        contentValues.put(COLUMN_BAKIM_ACIKLAMA,aciklama);
        contentValues.put(COLUMN_BAKIM_TUR,tur);
        db.insert(TABLE_BAKIM,null,contentValues);

        Cursor res =  db.rawQuery( "SELECT * FROM "+ TABLE_BAKIM+" ORDER BY "+COLUMN_BAKIM_ID+" DESC LIMIT 1", null );
        res.moveToFirst();

        return res.getString(res.getColumnIndex(COLUMN_BAKIM_ID));
    }

    public String insertYakıt (Date date, int litre, int fiyat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_YAKIT_TARIH, sdf.format(date));
        contentValues.put(COLUMN_YAKIT_FIYAT,fiyat);
        contentValues.put(COLUMN_YAKIT_LITRE,litre);
        db.insert(TABLE_YAKIT,null,contentValues);


        Cursor res =  db.rawQuery( "SELECT * FROM "+ TABLE_YAKIT+" ORDER BY "+COLUMN_YAKIT_ID+" DESC LIMIT 1", null );
        res.moveToFirst();

        System.out.println(res.getColumnIndex(COLUMN_YAKIT_LITRE)+" "+res.getColumnIndex(COLUMN_YAKIT_FIYAT));
        return res.getString(res.getColumnIndex(COLUMN_YAKIT_ID));
    }
    public String insertKM (Date date, int mesafe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_KM_TARIH,sdf.format(date));
        contentValues.put(COLUMN_KM_MESAFE,mesafe);
        db.insert(TABLE_KM,null,contentValues);

        Cursor res =  db.rawQuery( "SELECT * FROM "+ TABLE_KM+" ORDER BY "+COLUMN_KM_ID+" DESC LIMIT 1", null );
        res.moveToFirst();

        return res.getString(res.getColumnIndex(COLUMN_KM_ID));
    }
    public String insertParca (Date date, String parca, String acıklama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PARCA_TARIH, sdf.format(date));
        contentValues.put(COLUMN_PARCA_PARCA,parca);
        contentValues.put(COLUMN_PARCA_ACIKLAMA,acıklama);
        db.insert(TABLE_PARCA,null,contentValues);

        Cursor res =  db.rawQuery( "SELECT * FROM "+ TABLE_PARCA+" ORDER BY "+COLUMN_PARCA_ID+" DESC LIMIT 1", null );
        res.moveToFirst();

        return res.getString(res.getColumnIndex(COLUMN_PARCA_ID));
    }

    public boolean insertParcaGecis (int parcaID, int aracID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARAC_ID_PARCA_GECIS,aracID);
        contentValues.put(COLUMN_PARCA_ID_PARCA_GECIS,parcaID);
        db.insert(TABLE_PARCA_GECIS,null,contentValues);
        return true;
    }

    public boolean insertKMGecis (int kmID, int aracID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARAC_ID_KM_GECIS,aracID);
        contentValues.put(COLUMN_KM_ID_KM_GECIS,kmID);
        db.insert(TABLE_KM_GECIS,null,contentValues);
        return true;
    }

    public boolean insertYakıtGecis (int yakıtID, int aracID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARAC_ID_YAKIT_GECIS,aracID);
        contentValues.put(COLUMN_YAKIT_ID_YAKIT_GECIS,yakıtID);
        db.insert(TABLE_YAKIT_GECIS,null,contentValues);
        return true;
    }

    public boolean insertBakımGecis (int bakımID, int aracID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ARAC_ID_BAKIM_GECIS,aracID);
        contentValues.put(COLUMN_BAKIM_ID_BAKIM_GECIS,bakımID);
        db.insert(TABLE_BAKIM_GECIS,null,contentValues);
        return true;
    }

    public boolean insertSirket (String ad, int kredi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_AD_SIRKET,ad);
        contentValues.put(COLUMN_KREDI_SIRKET,kredi);
        db.insert(TABLE_SIRKET,null,contentValues);
        return true;
    }
    public boolean insertKirala (int aracID, int sirketID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID_ARAC_KIRALA,aracID);
        contentValues.put(COLUMN_ID_SIRKET_KIRALA,sirketID);
        db.insert(TABLE_KIRALA,null,contentValues);
        return true;
    }

    public Cursor checkPlaka(String plaka,Context context) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_ARAC+" where "+COLUMN_ARAC_PLAKA +"= '"+plaka+"'", null );
        res.moveToFirst();

        return res;
    }


    public boolean checkMalSahibi(String malSahibi){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_SIRKET+" where "+COLUMN_AD_SIRKET +"= '"+malSahibi+"'", null );

        if (res.getCount()==0) return false;
        else return true;
    }

    public boolean checkMal(String malSahibi){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_SIRKET+" where "+COLUMN_AD_SIRKET +"= '"+malSahibi+"'", null );
        res.moveToFirst();
        if (res.getString(res.getColumnIndex(COLUMN_KREDI_SIRKET))=="0"){
            return false;
        }
        else return true;
    }

    public Cursor getAllArac(int plaka){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_ARAC +" where "+COLUMN_ARAC_SIRKET +" = 'sirket' and "+COLUMN_ID_ARAC_SIRKET +" = -1" +
                " and "+COLUMN_ARAC_PLAKA +" = "+plaka , null );
        return res;
    }
    public Cursor getAllAracDepo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_ARAC+ " where "+COLUMN_ARAC_SIRKET +" = 'sirket' and "+COLUMN_ID_ARAC_SIRKET +" != -1", null );
        return res;
    }
    public String getAllBakım(String aracid) {
                //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_BAKIM +" , "+ TABLE_ARAC+ " , " + TABLE_BAKIM_GECIS
                        +" where "+aracid +" = "+COLUMN_ARAC_ID_BAKIM_GECIS +" AND " +COLUMN_BAKIM_ID+" = "+COLUMN_BAKIM_ID_BAKIM_GECIS
                , null );
        res.moveToFirst();
        String temp ="KM\n\t\t\t\tTARIH\t\tTUR\n";;

        while(res.isAfterLast() == false){
            temp += res.getString(res.getColumnIndex(COLUMN_BAKIM_TARIH))+"\t\t\t\t";
            temp += res.getString(res.getColumnIndex(COLUMN_BAKIM_TUR))+"\t\t\n";
            temp += "acıklama :: "+res.getString(res.getColumnIndex(COLUMN_BAKIM_ACIKLAMA))+"\n";
            res.moveToNext();
        }
        return temp;
    }
    public String getAllParca(String aracid) {


        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_PARCA +" , "+ TABLE_ARAC+ " , " + TABLE_PARCA_GECIS
                        +" where "+aracid +" = "+COLUMN_ARAC_ID_PARCA_GECIS +" AND " +COLUMN_PARCA_ID+" = "+COLUMN_PARCA_ID_PARCA_GECIS
                , null );
        res.moveToFirst();
        String temp ="Parça\n\t\t\t\tTARIH\t\tParca\n";;
        while(res.isAfterLast() == false){
            temp += res.getString(res.getColumnIndex(COLUMN_PARCA_TARIH))+"\t\t\t\t";
            temp += res.getString(res.getColumnIndex(COLUMN_PARCA_PARCA))+"\t\t\n";
            temp += "acıklama :: "+res.getString(res.getColumnIndex(COLUMN_PARCA_ACIKLAMA))+"\n";

            res.moveToNext();
        }
        return temp;
    }
    public String getAllKM(String aracid) {

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_KM +" , "+ TABLE_ARAC+ " , " + TABLE_KM_GECIS
                        +" where "+aracid +" = "+COLUMN_ARAC_ID_KM_GECIS +" AND " +COLUMN_KM_ID+" = "+COLUMN_KM_ID_KM_GECIS
                , null );
        res.moveToFirst();
        String temp ="KM\n\t\t\t\tTARIH\t\tMESAFE\n";

        while(res.isAfterLast() == false){
            temp+=res.getString(res.getColumnIndex(COLUMN_KM_TARIH))+"\t\t\t\t";
            temp+=res.getString(res.getColumnIndex(COLUMN_KM_MESAFE))+"\n";
            res.moveToNext();
        }
        return temp;
    }
    public String getAllYakıt(String aracid) {


        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_YAKIT +" , "+ TABLE_ARAC+ " , " + TABLE_YAKIT_GECIS
                +" where "+aracid +" = "+COLUMN_ARAC_ID_YAKIT_GECIS +" AND " +COLUMN_YAKIT_ID+" = "+COLUMN_YAKIT_ID_YAKIT_GECIS
                , null );
        res.moveToFirst();
        String temp="YAKIT\n\t\t\t\tTARIH\t\tFIYAT\t\t\tLITRE\n";
        while(res.isAfterLast() == false){

            temp += res.getString(res.getColumnIndex(COLUMN_YAKIT_TARIH))+"\t\t\t\t";
            temp += res.getString(res.getColumnIndex(COLUMN_YAKIT_FIYAT))+"\t\t\t\t";
            temp += res.getString(res.getColumnIndex(COLUMN_YAKIT_LITRE))+"\n";


            res.moveToNext();

        }
        return temp;
    }
}
