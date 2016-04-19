package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewPagerWithFragment extends FragmentActivity {
	private List<Fragment> fragmentlist = new ArrayList<Fragment>();
	private Button btn1, btn2, btn3, btn4;
	private ViewPager viewPager;
	// 当前页面编号
	private int curIndex;

	private FragmentViewPagerAdapter adapter;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main);

		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
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
				btn1.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(0);
				// Toast.makeText(ViewPagerWithFragment.this,
				// "您选择了第" + (curIndex + 1) + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn2.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.blue));
				btn1.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(1);
				// Toast.makeText(ViewPagerWithFragment.this,
				// "您选择了第" + curIndex + 1 + "个页面", Toast.LENGTH_SHORT)
				// .show();
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn3.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn1.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn4.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(2);
				// Toast.makeText(ViewPagerWithFragment.this, "您选择了第" + curIndex
				// + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});
		btn4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn4.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.blue));
				btn2.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn3.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				btn1.setTextColor(ViewPagerWithFragment.this.getResources()
						.getColor(R.color.font_color_gray_black));
				viewPager.setCurrentItem(3);
				// Toast.makeText(ViewPagerWithFragment.this, "您选择了第" + curIndex
				// + "个页面",
				// Toast.LENGTH_SHORT).show();
			}
		});

		Framgent1 f1 = new Framgent1();
		Framgent2 f2 = new Framgent2();
		Framgent3 f3 = new Framgent3();
		Framgent4 f4 = new Framgent4();
		fragmentlist.add(f1);
		fragmentlist.add(f2);
		fragmentlist.add(f3);
		fragmentlist.add(f4);
		adapter.notifyDataSetChanged();
	}

	private class FragmentViewPagerAdapter extends FragmentPagerAdapter {

		public FragmentViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return fragmentlist.get(position);
		}

		@Override
		public int getCount() {
			return fragmentlist.size();
		}

	}

}
