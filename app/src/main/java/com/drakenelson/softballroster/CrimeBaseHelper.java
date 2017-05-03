package com.drakenelson.softballroster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.drakenelson.softballroster.CrimeSchema.CrimeTable;
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
        String s = "CREATE TABLE " +" "+CrimeTable.NAME+" ( "+" _id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                CrimeTable.Cols.UUID+", "+
                CrimeTable.Cols.FIRST_NAME+", "+
                CrimeTable.Cols.LAST_NAME+", "+
                CrimeTable.Cols.NUMBER+", "+
                CrimeTable.Cols.POSITIONS+", "+
                CrimeTable.Cols.LAST_UPDATE+", "+
                CrimeTable.Cols.ISPITCHER+", "+
                CrimeTable.Cols.ISCATCHER+", "+
                CrimeTable.Cols.ISINFIELD+", "+
                CrimeTable.Cols.ISOUTFIELD+")";
        android.util.Log.d(TAG,s);
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.print("asdf");
    }
}
