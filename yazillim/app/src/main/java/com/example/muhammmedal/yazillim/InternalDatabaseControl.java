package com.example.muhammmedal.yazillim;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class InternalDatabaseControl {

    // Database fields
    private SQLiteDatabase database;
    private InternalDatabaseHelper internalDbHelper;

    private String[] allBooksColumns = {InternalDatabaseHelper.COLUMN_BOOK_ID, InternalDatabaseHelper.COLUMN_BOOK_TITLE, InternalDatabaseHelper.COLUMN_BOOK_PATH,
            InternalDatabaseHelper.COLUMN_BOOK_VERSION_ID, InternalDatabaseHelper.COLUMN_BOOK_DESCRIPTION,
            InternalDatabaseHelper.COLUMN_BOOK_ICON, InternalDatabaseHelper.COLUMN_BOOK_PRICE};

    public InternalDatabaseControl(Context context){
        internalDbHelper = new InternalDatabaseHelper(context);
    }

    public void openGeneralDatabase(){
        database = internalDbHelper.getWritableDatabase();
    }

    public void closeGeneralDatabase(){
        internalDbHelper.close();
    }
}