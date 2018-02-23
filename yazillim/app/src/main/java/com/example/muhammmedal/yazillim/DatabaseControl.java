package com.example.muhammmedal.yazillim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by MUHAMMMED ALİ on 23.05.2017.
 */

public class DatabaseControl {
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    public DatabaseControl(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

}
