package com.gaoyanpeng.androidtestjob;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.main_tab);
        mViewPager= (ViewPager) findViewById(R.id.main_vp);
    }

    private void initDate() {
    MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(0x00000000);
        //mTabLayout.setTabTextColors(0x997b7b7b,0x9961C564);
        mTabLayout.setTabTextColors(0x997b7b7b,0xffBE4F38);
        int tabCont = mTabLayout.getTabCount();
        for (int i = 0; i <tabCont ; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setIcon(MainTabInfo.getTabInfos().get(i).getImage());


        }
    }
}
