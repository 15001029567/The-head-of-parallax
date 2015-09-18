package com.example.yanshi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import com.example.headparallax.R;
import com.example.yanshi.fragment.fragment04;
public class MainActivity extends FragmentActivity  {
	private FrameLayout main_framelayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main_framelayout = (FrameLayout) findViewById(R.id.main_framelayout);
		fragment04 fragment04 = new fragment04();
		getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, fragment04, "FIRST").commit();
	}

}
