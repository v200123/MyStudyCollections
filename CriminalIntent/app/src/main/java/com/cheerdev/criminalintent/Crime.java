package com.cheerdev.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Gang on 2015/7/17.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {

        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean Solved) {
        mSolved = Solved;
    }

    public Date getDate() {

        return mDate;
    }

    public void setData(Date Data) {
        mDate = Data;
    }

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
