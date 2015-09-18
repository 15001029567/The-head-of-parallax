package com.example.yanshi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View view = getFragmentView();
	return view;
}
public abstract View getFragmentView();
@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	prepareData();
		super.onActivityCreated(savedInstanceState);
	}
	public abstract void prepareData();
}
