package com.drakenelson.softballroster.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.drakenelson.softballroster.Player;

import java.util.Date;
import java.util.UUID;

public class PlayerCursorWrapper extends CursorWrapper {
    public PlayerCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Player getPlayer() {
        String uuidString = getString(getColumnIndex(PlayerSchema.CrimeTable.Cols.UUID));
        String firstName = getString(getColumnIndex(PlayerSchema.CrimeTable.Cols.FIRST_NAME));
        String lastName = getString(getColumnIndex(PlayerSchema.CrimeTable.Cols.LAST_NAME));
        String num = getString(getColumnIndex(PlayerSchema.CrimeTable.Cols.NUMBER));
        String positions = getString(getColumnIndex(PlayerSchema.CrimeTable.Cols.POSITIONS));
        long date = getLong(getColumnIndex(PlayerSchema.CrimeTable.Cols.LAST_UPDATE));
        int isPitch = getInt(getColumnIndex(PlayerSchema.CrimeTable.Cols.ISPITCHER));
        int isCatch = getInt(getColumnIndex(PlayerSchema.CrimeTable.Cols.ISCATCHER));
        int isOut = getInt(getColumnIndex(PlayerSchema.CrimeTable.Cols.ISOUTFIELD));
        int isIn = getInt(getColumnIndex(PlayerSchema.CrimeTable.Cols.ISINFIELD));

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