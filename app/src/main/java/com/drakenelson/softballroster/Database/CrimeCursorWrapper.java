package com.drakenelson.softballroster.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.drakenelson.softballroster.Player;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Player getPlayer() {
        String uuidString = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.UUID));
        String firstName = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.FIRST_NAME));
        String lastName = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.LAST_NAME));
        String num = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.NUMBER));
        String positions = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.POSITIONS));
        long date = getLong(getColumnIndex(CrimeSchema.CrimeTable.Cols.LAST_UPDATE));
        int isPitch = getInt(getColumnIndex(CrimeSchema.CrimeTable.Cols.ISPITCHER));
        int isCatch = getInt(getColumnIndex(CrimeSchema.CrimeTable.Cols.ISCATCHER));
        int isOut = getInt(getColumnIndex(CrimeSchema.CrimeTable.Cols.ISOUTFIELD));
        int isIn = getInt(getColumnIndex(CrimeSchema.CrimeTable.Cols.ISINFIELD));

        Player crime = new Player(UUID.fromString(uuidString));
        crime.setLastUpdate(new Date(date));
        crime.setLastName(firstName);
        crime.setFirstName(lastName);
        crime.setNumber(num);
        crime.setPitcher(isPitch!=0);
        crime.setCatcher(isCatch!=0);
        crime.setInfield(isIn!=0);
        crime.setOutField(isOut!=0);
        crime.setPositions();

        return crime;
    }
}