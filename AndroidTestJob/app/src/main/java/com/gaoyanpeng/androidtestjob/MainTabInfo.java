package com.gaoyanpeng.androidtestjob;

import android.support.v4.app.Fragment;

import com.gaoyanpeng.androidtestjob.first.FirstFragment;
import com.gaoyanpeng.androidtestjob.second.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高研鹏 on 2016/11/11.
 */

public class MainTabInfo {
    private String title;
    private int image;
    private Fragment f;

    public MainTabInfo(Fragment f, String title, int image) {
        this.f = f;
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public MainTabInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public Fragment getF() {
        return f;
    }

    public MainTabInfo setF(Fragment f) {
        this.f = f;
        return this;
    }

    public int getImage() {
        return image;
    }

    public MainTabInfo setImage(int image) {
        this.image = image;
        return this;
    }
    public static List<MainTabInfo> getTabInfos(){
        List<MainTabInfo> infos = new ArrayList<>();
        infos.add(new MainTabInfo(new FirstFragment(),"首页",R.drawable.home_slestor));
        infos.add(new MainTabInfo(new SecondFragment(),"榜单",R.drawable.bang_slestor));
        return infos;

    }
}
