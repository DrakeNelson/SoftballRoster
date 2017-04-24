package com.drakenelson.softballroster;

import android.support.v4.app.Fragment;

/**
 * Created by user on 3/20/2017.
 */
public class RosterActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new RosterFragment();
    }
}
