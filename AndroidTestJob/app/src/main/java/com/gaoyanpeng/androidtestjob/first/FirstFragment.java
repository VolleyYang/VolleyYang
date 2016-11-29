package com.gaoyanpeng.androidtestjob.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaoyanpeng.androidtestjob.MainTabInfo;
import com.gaoyanpeng.androidtestjob.R;

/**
 * Created by 高研鹏 on 2016/11/11.
 */
public class FirstFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fm_first,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initDate();
    }



    private void initView() {
        mTabLayout = (TabLayout) getView().findViewById(R.id.first_tab);
        mViewPager = (ViewPager) getView().findViewById(R.id.first_vp);

    }
    private void initDate() {
        FirstAdapter adapter = new FirstAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(0x00000000);
        mTabLayout.setTabTextColors(0x997b7b7b,0xffBE4F38);

    }
}
