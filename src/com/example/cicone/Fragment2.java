package com.example.cicone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Fragment2 extends Fragment
{
	int number_of_posts=10;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout layout= (LinearLayout) getActivity().findViewById(R.id.list);
		View rootView = inflater.inflate(R.layout.fragment2,
				container, false);
		
		return rootView;
	}

}
