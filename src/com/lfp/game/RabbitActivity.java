package com.lfp.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

import com.lfp.test.R;

public class RabbitActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rabbit);
		
		FrameLayout frameLayout = (FrameLayout)findViewById(R.id.rabbitlayout);
		final RabbitView rabbit = new RabbitView(RabbitActivity.this);
		rabbit.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				rabbit.bitmapX=event.getX();
				rabbit.bitmapY=event.getY();
				rabbit.invalidate();
				return true;
			}
			
		});
		frameLayout.addView(rabbit);
	}

}