package com.shgmn.androiduitest.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.shgmn.androiduitest.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements
			OnClickListener {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			Button buttonNavigationDrawer = (Button) rootView
					.findViewById(R.id.button_navigation_drawer);
			buttonNavigationDrawer.setOnClickListener(this);
			Button buttonTab = (Button) rootView.findViewById(R.id.button_tab);
			buttonTab.setOnClickListener(this);
			Button buttonSpinner = (Button) rootView
					.findViewById(R.id.button_spinner);
			buttonSpinner.setOnClickListener(this);
			return rootView;
		}

		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case R.id.button_navigation_drawer: {
				Intent intent = new Intent(getActivity(),
						NavigationDrawerActivity.class);
				startActivity(intent);
			}
				break;
			case R.id.button_tab: {
				Intent intent = new Intent(getActivity(), TabActivity.class);
				startActivity(intent);
			}
				break;
			case R.id.button_spinner: {
				Intent intent = new Intent(getActivity(), SpinnerActivity.class);
				startActivity(intent);
			}
				break;
			default:
				break;
			}
		}
	}

}
