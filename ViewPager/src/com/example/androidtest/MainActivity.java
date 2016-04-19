package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn1, btn2, btn3, btn4;
	private ViewPager viewPager;
	// 当前页面编号
	private int curIndex;
	//
	private List<View> viewList = new ArrayList<View>();
	private int[] images = new int[] { R.drawable.img1, R.drawable.img2,
			R.drawable.img3, R.drawable.img4 };
	private String[] urls = new String[] { "http://www.ysten.com/",
			"https://www.baidu.com/", "http://weixin.qq.com/",
			"http://www.sina.com.cn/" };
	private ViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initView();
		initData();
	}

	private void initView() {
		findViewById();
		setListener();
	}

	private void initData() {
		for (int i = 0; i < 4; i++) {
			// ImageView view = new ImageView(this);
			// LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			// LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			// params.gravity = Gravity.CENTER;
			// view.setLayoutParams(params);
			// view.setImageResource(images[i]);
			// view.setScaleType(ScaleType.CENTER);
			// viewList.add(view);

			WebView view = new WebView(this);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			// params.gravity = Gravity.CENTER;
			view.setLayoutParams(params);
			// view.loadUrl(urls[i]);
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
			view.loadUrl(urls[i]);
			viewList.add(view);
		}

		adapter.notifyDataSetChanged();
	}

	private void findViewById() {
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		adapter = new ViewPagerAdapter();
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);

	}

	@SuppressWarnings("deprecation")
	private void setListener() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				curIndex = position;
				Toast.makeText(MainActivity.this,
						"您选择了第" + (curIndex + 1) + "个页面", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn1.setTextColor(MainActivity.this.getResources().getColor(
						R.color.blue));
				btn2.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn3.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn4.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				viewPager.setCurrentItem(0);
				// Toast.makeText(MainActivity.this,
				// "您选择了第" + (curIndex + 1) + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn2.setTextColor(MainActivity.this.getResources().getColor(
						R.color.blue));
				btn1.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn3.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn4.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				viewPager.setCurrentItem(1);
				// Toast.makeText(MainActivity.this,
				// "您选择了第" + curIndex + 1 + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn3.setTextColor(MainActivity.this.getResources().getColor(
						R.color.blue));
				btn2.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn1.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn4.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				viewPager.setCurrentItem(2);
				// Toast.makeText(MainActivity.this, "您选择了第" + curIndex + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});
		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn4.setTextColor(MainActivity.this.getResources().getColor(
						R.color.blue));
				btn2.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn3.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				btn1.setTextColor(MainActivity.this.getResources().getColor(
						R.color.font_color_gray_black));
				viewPager.setCurrentItem(3);
				// Toast.makeText(MainActivity.this, "您选择了第" + curIndex + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});

	}

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return viewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			viewPager.addView(viewList.get(position));
			return viewList.get(position);
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			viewPager.removeView(viewList.get(position));
		}

	}

}
