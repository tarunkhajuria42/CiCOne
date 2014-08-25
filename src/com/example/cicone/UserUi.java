package com.example.cicone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import Utils.InternetUtility;
public class UserUi extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_ui);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new SideOptions()).commit();
		}
		int duration = Toast.LENGTH_SHORT;
		Boolean a= InternetUtility.isNetworkAvailable(this);
		Toast toast = Toast.makeText(this,a.toString(), duration);
		toast.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_ui, menu);
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
		else if(id==R.id.options)
		{
			getSupportFragmentManager().beginTransaction()
			.replace(R.id.container, new Fragment2()).commit();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
