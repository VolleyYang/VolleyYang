package com.gaoyanpeng.androidtestjob;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 高研鹏 on 2016/11/11.
 */

public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainTabInfo.getTabInfos().get(position).getF();
    }

    @Override
    public int getCount() {
        return MainTabInfo.getTabInfos().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainTabInfo.getTabInfos().get(position).getTitle();
    }
}
