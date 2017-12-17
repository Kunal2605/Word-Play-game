package com.e.s.wordplay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Amit on 04-10-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="words";
    private static final String TABLE_NAME="words";
    private static final String KEY_ID="id";
    private static final String KEY_WORD="word";


    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_WORD
                +" TEXT, "+")";
        db.execSQL(CREATE_TABLE);

        this.getWritableDatabase();


        ContentValues values1 = new ContentValues();
        values1.put(KEY_ID, "1");
        values1.put(KEY_WORD,"WOOD");

        ContentValues values2 = new ContentValues();
        values2.put(KEY_ID, "2");
        values2.put(KEY_WORD,"FIRE");

        ContentValues values3 = new ContentValues();
        values3.put(KEY_ID, "3");
        values3.put(KEY_WORD,"WORD");


        ContentValues values4 = new ContentValues();
        values4.put(KEY_ID, "4");
        values4.put(KEY_WORD,"DOOR");

        ContentValues values5 = new ContentValues();
        values5.put(KEY_ID, "5");
        values5.put(KEY_WORD,"MADE");




    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Round> getWord(){
        String selectQuery="select * from "+TABLE_NAME;
        ArrayList<Round> roundArrayList=new ArrayList<Round>();
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        while (cursor.moveToNext())
        {
            Round round = new Round();
            round.setId(cursor.getInt(0));
            round.setWord(cursor.getString(1));
            roundArrayList.add(round);
        }

        return roundArrayList;
    }

    // Gets the data repository in write mode


}
