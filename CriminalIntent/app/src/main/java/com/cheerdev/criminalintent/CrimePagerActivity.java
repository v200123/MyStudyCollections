package com.cheerdev.criminalintent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Gang on 2015/7/20.
 */
public class CrimePagerActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);
        mCrimes = CrimeLab.get(this).getmCrimes();

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i = 0;i<mCrimes.size();i++){
            if (mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
     /**
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            public void onPageScrollStateChanged(int state){ }
            public void onPageScrolled(int pos,float posOffset,int posOffsetPixels){
                public void onPageSelected(int pos){
                    Crime crime = mCrimes.get(int pos){
                        if (crime.getTitle() != null){
                            setTitle(crime.getTitle());
                        }
                    }
                }
            }
        });
      */
    }
}
