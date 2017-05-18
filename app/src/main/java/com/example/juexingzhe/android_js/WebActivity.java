package com.example.juexingzhe.android_js;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.DefaultHandler;

/**
 * Created by lianlingneng on 2017/5/19.
 */

public class WebActivity extends Activity {


    private BridgeWebView mBridgeWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        Intent intent = this.getIntent();
        String email = intent.getStringExtra("email");

        mBridgeWebView = (BridgeWebView) findViewById(R.id.web_view);
        mBridgeWebView.setDefaultHandler(new DefaultHandler());

        mBridgeWebView.loadUrl("file:///android_asset/getuserinfo.html");
    }
}
