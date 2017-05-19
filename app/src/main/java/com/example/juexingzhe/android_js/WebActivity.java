package com.example.juexingzhe.android_js;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;

/**
 * Created by lianlingneng on 2017/5/19.
 */

public class WebActivity extends Activity {

    private static final String TAG = "WebActivity";


    private BridgeWebView mBridgeWebView;

    private UserInfo mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        Intent intent = this.getIntent();
        String email = intent.getStringExtra("email");

        mUserInfo = new UserInfo(email);

        mBridgeWebView = (BridgeWebView) findViewById(R.id.web_view);
        mBridgeWebView.setDefaultHandler(new DefaultHandler());

        mBridgeWebView.loadUrl("file:///android_asset/getuserinfo.html");

        registerHandler();
    }

    private void registerHandler() {
        mBridgeWebView.registerHandler("getUserInfo", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "handler = getUserInfo, data from web = " + data);
                function.onCallBack(new Gson().toJson(mUserInfo));
            }
        });
    }

}
