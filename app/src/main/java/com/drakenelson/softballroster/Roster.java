package com.drakenelson.softballroster;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Drake on 3/20/2017.
 */

public class Roster {
    private static Roster sCrimeLab;


    private List<Player> mCrimes;

    public static String TAG = "CrimeLab";
    //private List<Crime> crimes;


    private Roster(Context context){
        mCrimes = new ArrayList<>();
        for(int i=0;i<14;i++) {
            Player crime = new Player();
            crime.setNumber(i);
            crime.setFirstName("Asdf");
            crime.setLastName("Hjkl");
            mCrimes.add(crime);
        }
    }

    public static Roster get(Context context){
        if(sCrimeLab==null){
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

    public List<Player> getCrimes() {
        return mCrimes;
    }
}
