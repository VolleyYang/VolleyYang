package com.gaoyanpeng.androidtestjob.first.select;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gaoyanpeng.androidtestjob.R;
import com.gaoyanpeng.androidtestjob.tool.NetTool;
import com.gaoyanpeng.androidtestjob.tool.onHttpCallBack;

/**
 * Created by 高研鹏 on 2016/11/11.
 */
public class SelectFm extends Fragment {
    private ListView mListView;
    private SelectAdapter adapter;
    private static  final String URL = "http://api.liwushuo.com/v2/channels/104/items_v2?ad=2&gender=2&generation=2&limit=20&offset=0";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fm_selsc,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) getView().findViewById(R.id.sele_ls);
        adapter = new SelectAdapter(getContext());
    }

    private void initData() {
        NetTool.getInstance().startRequest(URL, SelectBean.class, new onHttpCallBack<SelectBean>() {
            @Override
            public void onSuccess(SelectBean response) {
                adapter.setSelectBean(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
