package com.drakenelson.softballroster;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class PlayerActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.drakenelson.criminalintentnotes.crime_id";


    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, PlayerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return PlayerFragment.newInstance(crimeId);
    }

}
