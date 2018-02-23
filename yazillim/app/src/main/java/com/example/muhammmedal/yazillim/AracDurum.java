package com.example.muhammmedal.yazillim;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AracDurum extends AppCompatActivity {

    ArrayList<String> kiralik,depo;
    ArrayList<String> kiralikId,depoId;
    EditText ad,plaka;
    DatabaseHelper mydb;
    int kiralıkid=-1,depoid=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_durum);
        mydb = new DatabaseHelper(this);

        ad = (EditText) findViewById(R.id.sirketAd);
        plaka = (EditText) findViewById(R.id.plakaAd);

        Button add = (Button) findViewById(R.id.addplaka);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = mydb.getReadableDatabase();
                Cursor res =  db.rawQuery( "select * from "+mydb.TABLE_ARAC +" where "+mydb.COLUMN_ARAC_SIRKET +" = 'sirket' and "+mydb.COLUMN_ID_ARAC_SIRKET +" = -1" +
                        " and "+mydb.COLUMN_ARAC_PLAKA +" = '"+plaka.getText().toString()+"'" , null );

                SQLiteDatabase bd = mydb.getReadableDatabase();
                Cursor ser =  bd.rawQuery( "select * from "+mydb.TABLE_SIRKET +" where "+mydb.COLUMN_AD_SIRKET +" = '"+ad.getText().toString()+"'", null );


                if (ser.getCount()==0 && res.getCount()==0){
                    Toast.makeText(AracDurum.this, "var olmayan sirket veya plaka", Toast.LENGTH_SHORT).show();
                }else if (mydb.checkMal(ad.getText().toString())){
                    Toast.makeText(AracDurum.this, "kredi notu kötü", Toast.LENGTH_SHORT).show();
                }else {
                    ContentValues cv = new ContentValues();
                    cv.put(mydb.COLUMN_ID_ARAC_SIRKET,mydb.COLUMN_ID_SIRKET); //These Fields should be your String values of actual column names


                    db.update(mydb.TABLE_ARAC, cv, mydb.COLUMN_ARAC_SIRKET +" = 'sirket' and "+mydb.COLUMN_ID_ARAC_SIRKET +" = -1", null);
                }

            }
        });

    }





}
