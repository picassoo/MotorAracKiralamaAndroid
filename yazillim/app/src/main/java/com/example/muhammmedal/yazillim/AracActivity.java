package com.example.muhammmedal.yazillim;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AracActivity extends AppCompatActivity {

    DatabaseHelper  mydb;
    public Context getContext(){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac);

        mydb = new DatabaseHelper(this);

        Button aracEkle = (Button) findViewById(R.id.aracEkle);
        final EditText marka = (EditText) findViewById(R.id.marka);
        final EditText model = (EditText) findViewById(R.id.model);
        final EditText plaka =  (EditText) findViewById(R.id.plakaNom);
        final EditText malsahibi = (EditText) findViewById(R.id.malsahibi);

        final String arac[] = new String[4];


        aracEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arac[0]=marka.getText().toString();
                arac[1]=model.getText().toString();
                arac[2]=plaka.getText().toString();
                arac[3]=malsahibi.getText().toString();
                boolean test;
                if (!arac[0].equals("") && !arac[0].equals("") && !arac[0].equals("") &&   !arac[0].equals("") ){
                    test=mydb.insertArac(arac[0],arac[1],arac[2],arac[3]);
                    if (test) Toast.makeText(AracActivity.this, "kaydedildi", Toast.LENGTH_SHORT).show();
                    else Toast.makeText(AracActivity.this, "kayıtlı olmayan şirket", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AracActivity.this, "boş karakter giriyorsunuz", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
    }

}
