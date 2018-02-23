package com.example.muhammmedal.yazillim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class sirketActivity extends AppCompatActivity {

    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirket);

        final EditText adSirket = (EditText) findViewById(R.id.adSirket);
        final SeekBar kredi = (SeekBar) findViewById(R.id.kredi);
        Button ekle = (Button) findViewById(R.id.sirketEkle);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!adSirket.getText().toString().equals("") ){
                    mydb.insertSirket(adSirket.getText().toString(),kredi.getProgress());
                    Toast.makeText(sirketActivity.this,""+kredi.getProgress() , Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(sirketActivity.this, "boş karakter giriyorsunuz", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
