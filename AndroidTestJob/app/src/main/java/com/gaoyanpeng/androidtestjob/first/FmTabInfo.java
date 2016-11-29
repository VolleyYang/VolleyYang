package com.gaoyanpeng.androidtestjob.first;

import android.support.v4.app.Fragment;

import com.gaoyanpeng.androidtestjob.first.select.DoubleTenthFm;
import com.gaoyanpeng.androidtestjob.first.select.SelectFm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 高研鹏 on 2016/11/11.
 */

public class FmTabInfo {
    private String title;
    private Fragment f;

    public FmTabInfo(Fragment f, String title) {
        this.f = f;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public FmTabInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public Fragment getF() {
        return f;
    }

    public FmTabInfo setF(Fragment f) {
        this.f = f;
        return this;
    }
    public static List<FmTabInfo> getFmTabInfo(){
        List<FmTabInfo> fmTabInfos= new ArrayList<>();
        fmTabInfos.add(new FmTabInfo(new SelectFm(),"精选"));
        fmTabInfos.add(new FmTabInfo(new DoubleTenthFm(),"双十一"));
        return fmTabInfos;
    }
}
