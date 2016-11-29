package com.gaoyanpeng.androidtestjob.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaoyanpeng.androidtestjob.R;
import com.gaoyanpeng.androidtestjob.tool.NetTool;
import com.gaoyanpeng.androidtestjob.tool.onHttpCallBack;

/**
 * Created by 高研鹏 on 2016/11/11.
 */
public class SecondFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SecondAdaper adapter;
    private static final String UIR= "http://api.liwushuo.com/v2/ranks_v3/ranks/6?limit=20&offset=0";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_second,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.second_re);
        adapter = new SecondAdaper(getContext());
    }

    private void initData() {
        NetTool.getInstance().startRequest(UIR, SecondBean.class, new onHttpCallBack<SecondBean>() {
            @Override
            public void onSuccess(SecondBean response) {
                adapter.setBean(response);
                mRecyclerView.setAdapter(adapter);
                StaggeredGridLayoutManager manger = new StaggeredGridLayoutManager(2,1);
                mRecyclerView.setLayoutManager(manger);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}

