package com.example.androidtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		WebView view = (WebView) findViewById(R.id.webView);
		
		view.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
				view.loadUrl(url);
				return true;
			}
		});

		// 启用支持JavaScript
		WebSettings settings = view.getSettings();
		// settings.setJavaScriptEnabled(true);
		// 隐藏webview缩放按钮
		// settings.setDisplayZoomControls(false);
		// 设置加载进来的页面自适应手机屏幕
		// settings.setUseWideViewPort(true);
		// settings.setLoadWithOverviewMode(true);
		// settings.setSupportZoom(true);

		// 支持javascript
		settings.setJavaScriptEnabled(true);
		// 设置可以支持缩放
		settings.setSupportZoom(true);
		// 设置出现缩放工具
		settings.setBuiltInZoomControls(true);
		// 扩大比例的缩放
		settings.setUseWideViewPort(true);
		// 自适应屏幕
		settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		settings.setLoadWithOverviewMode(true);
		view.loadUrl("http://www.baidu.com/");
	}
}
