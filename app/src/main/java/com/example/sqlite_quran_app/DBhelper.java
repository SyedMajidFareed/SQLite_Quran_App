package com.example.sqlite_quran_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DBhelper extends SQLiteAssetHelper {
    public static final String DBNAME = "quran_database.db";
    public static final int DBVERSION = 1;
    public static final String TNAME = "tsurah";

    public DBhelper(Context context) {
        super(context,DBNAME,null,DBVERSION);
    }
    //function to get data(recitation) from database
    public ArrayList<SurahModel> gettingSurah()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT SurahID, SurahNameE FROM tsurah" , null);


        ArrayList<SurahModel> data = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {

            do {
                data.add(new SurahModel(
                        cursorCourses.getString(0),
                        cursorCourses.getInt(1)
                ));

            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }
}
