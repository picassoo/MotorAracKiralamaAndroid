package com.example.muhammmedal.yazillim;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InternalDatabaseHelper extends SQLiteOpenHelper
{
    protected static final String TAG = "DataAdapter";

    private static final String DATABASE_NAME = "bibliapp.db";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_BOOKS = "table_books";
    public static final String COLUMN_BOOK_ID = "_bid";
    public static final String COLUMN_BOOK_TITLE = "b_title";
    public static final String COLUMN_BOOK_PATH = "b_path";
    public static final String COLUMN_BOOK_VERSION_ID = "b_version_id";
    public static final String COLUMN_BOOK_DESCRIPTION = "b_description";
    public static final String COLUMN_BOOK_ICON = "b_icon";
    public static final String COLUMN_BOOK_PRICE = "b_price";

    // TODO: Check which fields will be null or not
    private static final String DATABASE_CREATE_BOOKS = "create table "
            + TABLE_BOOKS + "("
            + COLUMN_BOOK_ID + " integer primary key autoincrement, "
            + COLUMN_BOOK_TITLE +" text not null, "
            + COLUMN_BOOK_PATH + " text, "
            + COLUMN_BOOK_VERSION_ID + " integer, "
            + COLUMN_BOOK_DESCRIPTION + " text not null, "
            + COLUMN_BOOK_ICON + " text not null, "
            + COLUMN_BOOK_PRICE + " text, "
            + "); ";

    public InternalDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate InternalDbManager");
        db.execSQL(DATABASE_CREATE_BOOKS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade InternalDbManager");
        Log.w(InternalDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }
}