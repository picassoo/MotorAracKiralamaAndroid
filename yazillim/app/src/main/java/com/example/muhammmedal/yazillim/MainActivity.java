package com.example.muhammmedal.yazillim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Calendar time = Calendar.getInstance();
    String DATE_FORMAT = "yyyy/MM/dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.güncelle);
        Button button2 = (Button) findViewById(R.id.araç);
        Button button3 = (Button) findViewById(R.id.araçDurum);
        Button button4 = (Button) findViewById(R.id.sirket);
        Button button5 = (Button) findViewById(R.id.rapor);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Guncelle.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AracActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AracDurum.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),sirketActivity.class);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RaporActivity.class);
                startActivity(intent);
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
        button.setText(sdf.format(time.getTime()));
    }
}
