package com.lfp.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	private TextView textView_result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		textView_result = (TextView)findViewById(R.id.textView_result);
		textView_result.setText(R.string.hello);
		
	}

	
}
