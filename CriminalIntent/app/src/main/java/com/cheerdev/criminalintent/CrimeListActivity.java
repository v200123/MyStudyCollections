package com.cheerdev.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Gang on 2015/7/19.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
