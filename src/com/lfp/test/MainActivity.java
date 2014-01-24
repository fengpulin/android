package com.lfp.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lfp.calculator.CalculatorActivity;

public class MainActivity extends Activity {

	private Button buttonCalculator = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonCalculator = (Button) findViewById(R.id.button_calculator);
		buttonCalculator.setOnClickListener(new ButtonCalculatorListener());
	}

	class ButtonCalculatorListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, CalculatorActivity.class);
			MainActivity.this.startActivity(intent);

		}

	}
}