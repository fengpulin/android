package com.lfp.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lfp.MediaPlayer.MediaPlayerActivity;
import com.lfp.calculator.CalculatorActivity;

public class MainActivity extends Activity {

	private Button button_calculator = null;
	private Button button_mediaPlayer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button_calculator = (Button) findViewById(R.id.button_calculator);
		button_calculator.setOnClickListener(new ButtonCalculatorListener());
		button_mediaPlayer = (Button) findViewById(R.id.button_mediaPlayer);
		button_mediaPlayer.setOnClickListener(new ButtonMediaPlayerListener());
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
	
	class ButtonMediaPlayerListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, MediaPlayerActivity.class);
			MainActivity.this.startActivity(intent);
		}
		
	}
}