package com.drakenelson.softballroster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.drakenelson.softballroster.Database.PlayerBaseHelper;
import com.drakenelson.softballroster.Database.PlayerCursorWrapper;
import com.drakenelson.softballroster.Database.PlayerSchema.CrimeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Drake on 3/20/2017.
 */

public class Roster {
    private static Roster sCrimeLab;

    //DATABASE VARIABLES
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static String TAG = "CrimeLab";
    //private List<Crime> crimes;


    private Roster(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new PlayerBaseHelper(mContext).getWritableDatabase();


    }

    public static Roster get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new Roster(context);
        }
        return sCrimeLab;
    }

    public Player getCrime(UUID id) {
        PlayerCursorWrapper cursor = queryCrimes(
                CrimeTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getPlayer();
        } finally {
            cursor.close();
        }
    }

    private static ContentValues getContentValues(Player crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID, crime.getId().toString());
        values.put(CrimeTable.Cols.FIRST_NAME, crime.getFirstName());
        values.put(CrimeTable.Cols.LAST_NAME, crime.getLastName());
        values.put(CrimeTable.Cols.NUMBER, crime.getNumber().toString());
        values.put(CrimeTable.Cols.POSITIONS, crime.getPositions());
        values.put(CrimeTable.Cols.LAST_UPDATE, crime.getLastUpdate().toString());
        values.put(CrimeTable.Cols.ISCATCHER, crime.isCatcher()?1:0);
        values.put(CrimeTable.Cols.ISPITCHER, crime.isPitcher()?1:0);
        values.put(CrimeTable.Cols.ISINFIELD, crime.isInfield()?1:0);
        values.put(CrimeTable.Cols.ISOUTFIELD, crime.isOutfield()?1:0);

        return values;
    }

    public List<Player> getCrimes() {
        List<Player> crimes = new ArrayList<>();

        PlayerCursorWrapper cursor = queryCrimes(null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            crimes.add(cursor.getPlayer());
            cursor.moveToNext();
        }
        cursor.close();

        return crimes;
    }
    public void addCrime(Player c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeTable.NAME, null, values);
    }
    public void updateCrime(Player crime) {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeTable.NAME, values,
                CrimeTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }
    private PlayerCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CrimeTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        return new PlayerCursorWrapper(cursor);
    }

}
