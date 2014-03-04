package com.lfp.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.lfp.test.R;
import com.lfp.tools.StringTools;

public class CalculatorActivity extends Activity {

	private TextView textView_inputNumber = null;
	private TextView textView_expressions = null;
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
	private Button button_point = null;
	private Button button_add = null;
	private Button button_sub = null;
	private Button button_mul = null;
	private Button button_div = null;
	private Button button_equal = null;
	private Button button_clear = null;
	private String inputNumber = "";
	private String operand = "";
	private String expressions = "";
	private boolean inputStart = true;
	private Operator operator = null;

	private enum Operator {
		ADD, SUB, MUL, DIV

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		textView_inputNumber = (TextView) findViewById(R.id.textView_inputNumber);
		textView_inputNumber.setText(inputNumber);
		textView_expressions = (TextView) findViewById(R.id.textView_expressions);
		textView_expressions.setText(expressions);
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
		button_point = (Button) findViewById(R.id.button_point);
		button_point.setOnClickListener(new ButtonPointListener());
		button_add = (Button) findViewById(R.id.button_add);
		button_add.setOnClickListener(new ButtonAddListener());
		button_sub = (Button) findViewById(R.id.button_sub);
		button_sub.setOnClickListener(new ButtonSubListener());
		button_mul = (Button) findViewById(R.id.button_mul);
		button_mul.setOnClickListener(new ButtonMulListener());
		button_div = (Button) findViewById(R.id.button_div);
		button_div.setOnClickListener(new ButtonDivListener());
		button_equal = (Button) findViewById(R.id.button_equal);
		button_equal.setOnClickListener(new ButtonEqualListener());
		button_clear = (Button) findViewById(R.id.button_clear);
		button_clear.setOnClickListener(new ButtonClearListener());
	}

	class ButtonClearListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			inputNumber = "0";
			operand = "0";
			expressions = "";
			inputStart = true;
			operator = null;
			textView_inputNumber.setText("0");
			textView_expressions.setText("");
		}
	}

	class ButtonEqualListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			inputStart = true;
			if (StringTools.isNullOrEmpty(inputNumber)) {
				inputNumber = "0";
			}
			if (StringTools.isNullOrEmpty(operand)) {
				operand = "0";
			}

			String result = "0";
			if (!StringTools.isNullOrEmpty(operand)
					&& !StringTools.isNullOrEmpty(inputNumber)
					&& operator != null) {
				switch (operator) {
				case ADD:
					result = String.valueOf(StringTools.strToNum(operand)
							+ StringTools.strToNum(inputNumber));
					break;
				case SUB:
					result = String.valueOf(StringTools.strToNum(operand)
							- StringTools.strToNum(inputNumber));
					break;
				case MUL:
					result = String.valueOf(StringTools.strToNum(operand)
							* StringTools.strToNum(inputNumber));
					break;
				case DIV:
					result = String.valueOf(StringTools.strToNum(operand)
							/ StringTools.strToNum(inputNumber));
					break;
				default:
					break;
				}
			}
			operand = result;
			textView_inputNumber.setText(result);
			textView_expressions.setText("");
		}
	}

	class ButtonAddListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			inputNumber = textView_inputNumber.getText().toString();
			operator = Operator.ADD;
			inputStart = true;
			operand = inputNumber;
			expressions = operand + "+";
			textView_inputNumber.setText(inputNumber);
			textView_expressions.setText(expressions);
		}
	}

	class ButtonSubListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			inputNumber = textView_inputNumber.getText().toString();
			operator = Operator.SUB;
			inputStart = true;
			operand = inputNumber;
			expressions = operand + "-";
			textView_inputNumber.setText(inputNumber);
			textView_expressions.setText(expressions);
		}
	}

	class ButtonMulListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			inputNumber = textView_inputNumber.getText().toString();
			operator = Operator.MUL;
			inputStart = true;
			operand = inputNumber;
			expressions = operand + "*";
			textView_inputNumber.setText(inputNumber);
			textView_expressions.setText(expressions);
		}
	}

	class ButtonDivListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			inputNumber = textView_inputNumber.getText().toString();
			operator = Operator.DIV;
			inputStart = true;
			operand = inputNumber;
			expressions = operand + "/";
			textView_inputNumber.setText(inputNumber);
			textView_expressions.setText(expressions);
		}
	}

	class ButtonPointListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				if (StringTools.isNullOrEmpty(inputNumber)) {
					inputNumber = "0";
				}
				if (!StringTools.isInt(inputNumber)) {
					return;
				}

				inputNumber += ".";
			} else {
				inputNumber = "0.";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonZeroListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				if (StringTools.isInt(inputNumber)
						&& Double.compare(StringTools.strToNum(inputNumber),
								0.0) == 0) {
					return;
				}
				inputNumber += "0";
			} else {
				inputNumber = "0";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonOneListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "1";
			} else {
				inputNumber = "1";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonTwoListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "2";
			} else {
				inputNumber = "2";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonThreeListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "3";
			} else {
				inputNumber = "3";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonFourListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "4";
			} else {
				inputNumber = "4";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonFiveListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "5";
			} else {
				inputNumber = "5";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonSixListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "6";
			} else {
				inputNumber = "6";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonSevenListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "7";
			} else {
				inputNumber = "7";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonEightListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "8";
			} else {
				inputNumber = "8";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

	class ButtonNineListener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			if (inputStart == false) {
				inputNumber += "9";
			} else {
				inputNumber = "9";
				inputStart = false;
			}
			textView_inputNumber.setText(inputNumber);
		}

	}

}
