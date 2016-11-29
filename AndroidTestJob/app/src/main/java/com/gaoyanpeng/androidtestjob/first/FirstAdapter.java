package com.gaoyanpeng.androidtestjob.first;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.text.FieldPosition;

/**
 * Created by 高研鹏 on 2016/11/11.
 */

public class FirstAdapter extends FragmentPagerAdapter {
    public FirstAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FmTabInfo.getFmTabInfo().get(position).getF();
    }

    @Override
    public int getCount() {
        return FmTabInfo.getFmTabInfo().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FmTabInfo.getFmTabInfo().get(position).getTitle();
    }
}
