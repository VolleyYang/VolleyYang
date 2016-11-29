package com.gaoyanpeng.androidtestjob.second;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gaoyanpeng.androidtestjob.R;
import com.gaoyanpeng.androidtestjob.tool.NetTool;
import com.gaoyanpeng.androidtestjob.tool.onHttpCallBack;

/**
 * Created by 高研鹏 on 2016/11/12.
 */
public class SecondAty extends AppCompatActivity{
    private WebView mWebView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_second);
        mWebView = (WebView) findViewById(R.id.se_web_view);
        WebViewClient webViewClient = new WebViewClient();
        mWebView.setWebViewClient(webViewClient);
        WebSettings wSet = mWebView.getSettings();
        wSet.setJavaScriptEnabled(true);
//        mWebView.setFocusable(true);
//       mWebView.setWebViewClient(new WebViewClient(){
//           @Override
//           public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//               view.loadUrl(UIR);
//               return true;
//           }
//       });
//        WebViewClient webViewClient = new WebViewClient();
//
//        WebSettings wSet = mWebView.getSettings();
//        wSet.setJavaScriptEnabled(true);
//        wSet.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        initView();

    }

    private void initView() {
        Intent intent = getIntent();
        String UrlB= intent.getStringExtra("urlB");
        Log.d("SecondAty", UrlB);
        mWebView.loadUrl(UrlB);

    }




}
