package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewPagerWithActivity extends Activity {
	private Button btn1, btn2, btn3, btn4;
	private ViewPager viewPager;
	// 当前页面编号
	private int curIndex;
	private LocalActivityManager manager;
	private List<View> viewlist = new ArrayList<View>();
	private PagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		adapter = new PagerAdapter() {

			@Override
			public int getCount() {
				return viewlist.size();
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public Object instantiateItem(View container, int position) {
				viewPager.addView(viewlist.get(position));
				return viewlist.get(position);
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				viewPager.removeView(viewlist.get(position));
			}

		};
		viewPager.setAdapter(adapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				curIndex = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn1.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(0);
				// Toast.makeText(ViewPagerWithActivity.this,
				// "您选择了第" + (curIndex + 1) + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn2.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.blue));
				btn1.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(1);
				// Toast.makeText(ViewPagerWithActivity.this,
				// "您选择了第" + curIndex + 1 + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn3.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn1.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(2);
				// Toast.makeText(ViewPagerWithActivity.this, "您选择了第" + curIndex
				// + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});
		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn4.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn1.setTextColor(ViewPagerWithActivity.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(3);
				// Toast.makeText(ViewPagerWithActivity.this, "您选择了第" + curIndex
				// + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});

		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);

		Intent intent1 = new Intent(this, Activity1.class);
		Intent intent2 = new Intent(this, Activity2.class);
		Intent intent3 = new Intent(this, Activity3.class);
		Intent intent4 = new Intent(this, Activity4.class);
		viewlist.add(getView("activity1", intent1));
		viewlist.add(getView("activity2", intent2));
		viewlist.add(getView("activity3", intent3));
		viewlist.add(getView("activity4", intent4));
		adapter.notifyDataSetChanged();
	}

	private View getView(String id, Intent intent) {
		return manager.startActivity(id, intent).getDecorView();
	}
}
