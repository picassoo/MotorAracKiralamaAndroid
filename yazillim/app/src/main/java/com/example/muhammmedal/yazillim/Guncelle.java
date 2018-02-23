package com.example.muhammmedal.yazillim;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Guncelle extends AppCompatActivity {

    Calendar time = Calendar.getInstance();
    String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    Button temp;
    DatabaseHelper  mydb;
    boolean plakaVar=false;
    String aracId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        mydb = new DatabaseHelper(this);

        final Button yakitTarih = (Button) findViewById(R.id.tarihYakıt);
        final Button kmTarih = (Button) findViewById(R.id.kmTarih);
        final Button bakımTarih = (Button) findViewById(R.id.bakımTarih);
        final Button parcaTarih = (Button) findViewById(R.id.parcaTarih);

        Button plakaSearch = (Button) findViewById(R.id.plakoSearch);
        Button yakıtGüncel = (Button) findViewById(R.id.yakitgün);
        Button kmGüncel = (Button) findViewById(R.id.kmgün);
        Button bakımGüncel = (Button) findViewById(R.id.bakimgün);
        Button parcaGüncel = (Button) findViewById(R.id.parcagün);

        final EditText fiyatYakıt = (EditText) findViewById(R.id.fiyatYakıt);
        final EditText litreYakıt = (EditText) findViewById(R.id.litreYakıt);

        final EditText mesafeKm = (EditText) findViewById(R.id.mesafeKm);

        final EditText turBakım = (EditText) findViewById(R.id.bakımTür);
        final EditText aciklamaBakım = (EditText) findViewById(R.id.acıklamaBakım);

        final EditText parcaParca = (EditText) findViewById(R.id.parcaParca);
        final EditText aciklamaParca = (EditText) findViewById(R.id.parcaAcıkla);

        yakıtGüncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!yakitTarih.getText().toString().equals("") &&
                    !litreYakıt.getText().toString().equals("") &&
                    !fiyatYakıt.getText().toString().equals("") && plakaVar){

                    try {
                        String key= mydb.insertYakıt(sdf.parse(yakitTarih.getText().toString()),
                                Integer.parseInt(litreYakıt.getText().toString()),
                                Integer.parseInt(fiyatYakıt.getText().toString()));
                        Toast.makeText(Guncelle.this,key, Toast.LENGTH_SHORT).show();
                        mydb.insertYakıtGecis(Integer.parseInt(key),
                                Integer.parseInt(aracId));
                        SQLiteDatabase db = mydb.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        Cursor res =  db.rawQuery( "SELECT * FROM "+mydb.TABLE_YAKIT_GECIS+" ORDER BY "
                                +mydb.COLUMN_ID_YAKIT_GECIS+" DESC LIMIT 1", null );
                        res.moveToFirst();
                        int fe=res.getColumnIndex(res.getColumnName(Integer.parseInt(mydb.COLUMN_ID_YAKIT_GECIS)));
                        Toast.makeText(Guncelle.this,"gecis "+ fe , Toast.LENGTH_SHORT).show();


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }else if (plakaVar){
                    Toast.makeText(Guncelle.this, "eksik bilgi girmeyiniz", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Guncelle.this, "girili plaka yok", Toast.LENGTH_SHORT).show();
                }
            }
        });
        kmGüncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!kmTarih.getText().toString().equals("") &&
                        !mesafeKm.getText().toString().equals("")  && plakaVar){

                    try {
                        String key= mydb.insertKM(sdf.parse(kmTarih.getText().toString()),
                                Integer.parseInt(mesafeKm.getText().toString()));

                        mydb.insertKMGecis(Integer.parseInt(key),
                                Integer.parseInt(aracId));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }else if (plakaVar){
                    Toast.makeText(Guncelle.this, "eksik bilgi girmeyiniz", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Guncelle.this, "girili plaka yok", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bakımGüncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bakımTarih.getText().toString().equals("") &&
                        !aciklamaBakım.getText().toString().equals("") &&
                        !turBakım.getText().toString().equals("")&& plakaVar){

                    try {
                        String key= mydb.insertBakım(sdf.parse(bakımTarih.getText().toString()),
                                aciklamaBakım.getText().toString(),turBakım.getText().toString()
                                );

                        mydb.insertBakımGecis(Integer.parseInt(key),
                                Integer.parseInt(aracId));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }else if (plakaVar){
                    Toast.makeText(Guncelle.this, "eksik bilgi girmeyiniz", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Guncelle.this, "girili plaka yok", Toast.LENGTH_SHORT).show();
                }
            }
        });

        parcaGüncel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!parcaTarih.getText().toString().equals("") &&
                        !aciklamaParca.getText().toString().equals("") &&
                        !parcaParca.getText().toString().equals("")&& plakaVar){

                    try {
                        String key= mydb.insertParca(sdf.parse(bakımTarih.getText().toString()),
                                parcaParca.getText().toString(),aciklamaParca.getText().toString()
                        );

                        mydb.insertParcaGecis(Integer.parseInt(key),
                                Integer.parseInt(aracId));

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }else if (plakaVar){
                    Toast.makeText(Guncelle.this, "eksik bilgi girmeyiniz", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Guncelle.this, "girili plaka yok", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final EditText plakaNo = (EditText) findViewById(R.id.plakaNo);
        final String[] plaka = new String[1];

        plakaSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((plaka[0] =plakaNo.getText().toString()).equals("")){
                    Toast.makeText(Guncelle.this, "plaka girilmemiş", Toast.LENGTH_SHORT).show();
                    plakaVar=false;
                    return;
                }else{
                    Cursor res = mydb.checkPlaka(plaka[0],Guncelle.this);
                    if (res.getCount()!=0){
                        plakaVar=true;
                        aracId=res.getString(res.getColumnIndex(mydb.COLUMN_ARAC_ID));
                        Toast.makeText(Guncelle.this, "plaka var", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        plakaVar=false;
                        Toast.makeText(Guncelle.this, "plaka yok", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        yakitTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=yakitTarih;
                updateDate();
            }
        });
        kmTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=kmTarih;
                updateDate();
            }
        });
        bakımTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=bakımTarih;
                updateDate();
            }
        });
        parcaTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp=parcaTarih;
                updateDate();
            }
        });
    }
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            time.set(Calendar.YEAR,year);
            time.set(Calendar.MONTH,month);
            time.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateText();
        }
    };

    private void updateDate(){
        new DatePickerDialog(this,dateSetListener,time.get(Calendar.YEAR),time.get(Calendar.MONTH),time.get(Calendar.DAY_OF_MONTH)).show();

    }
    private void updateText(){
        temp.setText(sdf.format(time.getTime()));
    }
}
