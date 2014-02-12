package com.lfp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lfp.test.R;

public class CalculatorActivity extends Activity {

	private TextView textView_input = null;
	private Button button_zero = null;
	private Button button_one = null;
	private Button button_two = null;
	private Button button_three = null;
	private Button button_four = null;
	private Button button_five = null;
	private Button button_six = null;
	private Button button_seven = null;
	private Button button_eight = null;
	private Button button_nine = null;
	private String input = "";
	//private String output = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		textView_input = (TextView) findViewById(R.id.textView_input);
		input = textView_input.getText().toString();
		button_zero = (Button) findViewById(R.id.button_zero);
		button_zero.setOnClickListener(new ButtonZeroListener());
		button_one = (Button) findViewById(R.id.button_one);
		button_one.setOnClickListener(new ButtonOneListener());
		button_two = (Button) findViewById(R.id.button_two);
		button_two.setOnClickListener(new ButtonTwoListener());
		button_three = (Button) findViewById(R.id.button_three);
		button_three.setOnClickListener(new ButtonThreeListener());
		button_four = (Button) findViewById(R.id.button_four);
		button_four.setOnClickListener(new ButtonFourListener());
		button_five = (Button) findViewById(R.id.button_five);
		button_five.setOnClickListener(new ButtonFiveListener());
		button_six = (Button) findViewById(R.id.button_six);
		button_six.setOnClickListener(new ButtonSixListener());
		button_seven = (Button) findViewById(R.id.button_seven);
		button_seven.setOnClickListener(new ButtonSevenListener());
		button_eight = (Button) findViewById(R.id.button_eight);
		button_eight.setOnClickListener(new ButtonEightListener());
		button_nine = (Button) findViewById(R.id.button_nine);
		button_nine.setOnClickListener(new ButtonNineListener());

	}

	class ButtonPointListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class ButtonZeroListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "0";
			textView_input.setText(input);
		}

	}

	class ButtonOneListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "1";
			textView_input.setText(input);
		}

	}

	class ButtonTwoListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "2";
			textView_input.setText(input);
		}

	}

	class ButtonThreeListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "3";
			textView_input.setText(input);
		}

	}

	class ButtonFourListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "4";
			textView_input.setText(input);
		}

	}

	class ButtonFiveListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "5";
			textView_input.setText(input);
		}

	}

	class ButtonSixListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "6";
			textView_input.setText(input);
		}

	}

	class ButtonSevenListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "7";
			textView_input.setText(input);
		}

	}

	class ButtonEightListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "8";
			textView_input.setText(input);
		}

	}

	class ButtonNineListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			input += "9";
			textView_input.setText(input);
		}

	}
}
