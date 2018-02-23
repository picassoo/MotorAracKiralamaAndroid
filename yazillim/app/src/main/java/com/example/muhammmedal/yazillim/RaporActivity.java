package com.example.muhammmedal.yazillim;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RaporActivity extends AppCompatActivity {
    Boolean plakaVar=false;
    String aracId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapor);

        Button plakaSearch = (Button) findViewById(R.id.plakoAra);
            final EditText plakaNo = (EditText) findViewById(R.id.plakaNumara);
            final TextView all = (TextView) findViewById(R.id.all);
        final String[] plaka = new String[1];
        final DatabaseHelper mydb = new DatabaseHelper(this);


        plakaSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((plaka[0] =plakaNo.getText().toString()).equals("")){
                    Toast.makeText(RaporActivity.this, "plaka girilmemiş", Toast.LENGTH_SHORT).show();
                    plakaVar=false;
                    return;
                }else{
                    Cursor res = mydb.checkPlaka(plaka[0],RaporActivity.this);
                    if (res.getCount()!=0){
                        plakaVar=true;
                        aracId=res.getString(res.getColumnIndex(mydb.COLUMN_ARAC_ID));

                        String temp="";
                        temp += mydb.getAllYakıt(aracId)+"\n";
                        temp += mydb.getAllKM(aracId)+"\n";
                        temp += mydb.getAllParca(aracId)+"\n";
                        temp += mydb.getAllBakım(aracId);
                        all.setText(temp);
                    }
                    else{                       plakaVar=false;
                        Toast.makeText(RaporActivity.this, "plaka yok", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
