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
    public String[] gettingArabic()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT Arabic_Text FROM tayah" , null);

        int i = 0;
        String[] data = new String[6348];
        if (cursorCourses.moveToFirst()) {

            do {
                data[i] = (
                        cursorCourses.getString(0)
                );
        i++;
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return data;
    }
}
