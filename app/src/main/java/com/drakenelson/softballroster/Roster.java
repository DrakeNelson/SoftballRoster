package com.drakenelson.softballroster;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Drake on 3/20/2017.
 */

public class Roster {
    private static Roster sCrimeLab;


    private List<Player> mCrimes;

    //DATABASE VARIABLES
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static String TAG = "CrimeLab";
    //private List<Crime> crimes;


    private Roster(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();

        mCrimes = new ArrayList<>();
//        for (int i = 0; i < 14; i++) {
//            Player crime = new Player();
//            crime.setNumber(i);
//            crime.setFirstName("Asdf");
//            crime.setLastName("Hjkl");
//            mCrimes.add(crime);
//        }
    }

    public static Roster get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new Roster(context);
        }
        return sCrimeLab;
    }

    public Player getCrime(UUID uuid) {
        for (Player crime : mCrimes) {
            if (crime.getId().equals(uuid)) {
                return crime;
            }
        }
        return null;
    }

    private static ContentValues getContentValues(Player crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeSchema.CrimeTable.Cols.UUID, crime.getId().toString());
        values.put(CrimeSchema.CrimeTable.Cols.FIRST_NAME, crime.getFirstName());
        values.put(CrimeSchema.CrimeTable.Cols.LAST_NAME, crime.getLastName());
        values.put(CrimeSchema.CrimeTable.Cols.NUMBER, crime.getNumber().toString());
        values.put(CrimeSchema.CrimeTable.Cols.POSITIONS, crime.getPositions());
        values.put(CrimeSchema.CrimeTable.Cols.LAST_UPDATE, crime.getLastUpdate().toString());
        values.put(CrimeSchema.CrimeTable.Cols.ISCATCHER, crime.isCatcher()?1:0);
        values.put(CrimeSchema.CrimeTable.Cols.ISPITCHER, crime.isPitcher()?1:0);
        values.put(CrimeSchema.CrimeTable.Cols.ISINFIELD, crime.isInfield()?1:0);
        values.put(CrimeSchema.CrimeTable.Cols.ISOUTFIELD, crime.isOutfield()?1:0);

        return values;
    }

    public List<Player> getCrimes() {
        List<Player> crimes = new ArrayList<>();

//        CrimeCursorWrapper cursor = queryCrimes(null, null);

//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            crimes.add(cursor.getCrime());
//            cursor.moveToNext();
//        }
//        cursor.close();

        return crimes;
    }
    public void addCrime(Player c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeSchema.CrimeTable.Cols.FIRST_NAME, null, values);
    }
}
