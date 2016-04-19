package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;

public class Activity1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment1);
	}
}
