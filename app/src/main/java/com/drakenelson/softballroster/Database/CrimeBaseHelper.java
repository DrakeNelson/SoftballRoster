package com.drakenelson.softballroster.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 4/24/2017.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME="crimeBase.db";
    private static final String TAG = "SQLiteOpenHelper";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase ) {
        String s = "CREATE TABLE " +" "+ CrimeSchema.CrimeTable.NAME+" ( "+" _id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                CrimeSchema.CrimeTable.Cols.UUID+", "+
                CrimeSchema.CrimeTable.Cols.FIRST_NAME+", "+
                CrimeSchema.CrimeTable.Cols.LAST_NAME+", "+
                CrimeSchema.CrimeTable.Cols.NUMBER+", "+
                CrimeSchema.CrimeTable.Cols.POSITIONS+", "+
                CrimeSchema.CrimeTable.Cols.LAST_UPDATE+", "+
                CrimeSchema.CrimeTable.Cols.ISPITCHER+", "+
                CrimeSchema.CrimeTable.Cols.ISCATCHER+", "+
                CrimeSchema.CrimeTable.Cols.ISINFIELD+", "+
                CrimeSchema.CrimeTable.Cols.ISOUTFIELD+")";
        android.util.Log.d(TAG,s);
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //System.out.print("asdf");
    }
}