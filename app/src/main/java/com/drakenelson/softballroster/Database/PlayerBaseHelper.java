package com.drakenelson.softballroster.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 4/24/2017.
 */

public class PlayerBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME="crimeBase.db";
    private static final String TAG = "SQLiteOpenHelper";

    public PlayerBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase ) {
        String s = "CREATE TABLE " +" "+ PlayerSchema.CrimeTable.NAME+" ( "+" _id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                PlayerSchema.CrimeTable.Cols.UUID+", "+
                PlayerSchema.CrimeTable.Cols.FIRST_NAME+", "+
                PlayerSchema.CrimeTable.Cols.LAST_NAME+", "+
                PlayerSchema.CrimeTable.Cols.NUMBER+", "+
                PlayerSchema.CrimeTable.Cols.POSITIONS+", "+
                PlayerSchema.CrimeTable.Cols.LAST_UPDATE+", "+
                PlayerSchema.CrimeTable.Cols.ISPITCHER+", "+
                PlayerSchema.CrimeTable.Cols.ISCATCHER+", "+
                PlayerSchema.CrimeTable.Cols.ISINFIELD+", "+
                PlayerSchema.CrimeTable.Cols.ISOUTFIELD+")";
        android.util.Log.d(TAG,s);
        sqLiteDatabase.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //System.out.print("asdf");
    }
}
