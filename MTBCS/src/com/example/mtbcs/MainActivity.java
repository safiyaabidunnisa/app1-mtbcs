package com.example.mtbcs;
import android.os.Handler;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Handler().postDelayed(new Runnable()
		{
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),Home.class));
			}
		},2000);
	}

	
}
