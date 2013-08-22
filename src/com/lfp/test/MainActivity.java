package com.lfp.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText editText_getName;
	
	private Button button_login;
	
	private TextView textView_showLogin;
	
	private Button button_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText_getName = (EditText)findViewById(R.id.editText_getName);
        
        button_login = (Button)findViewById(R.id.button_login);
        
        textView_showLogin = (TextView)findViewById(R.id.textView_showLogin);
        
        button_result = (Button)findViewById(R.id.button_result);
        
        button_login.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		textView_showLogin.setText("hello"+editText_getName.getText());
        	}
        	
        });
        
        button_result.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent showResult_intent = new Intent(MainActivity.this,ResultActivity.class);
				startActivity(showResult_intent);
				
			}
        	
        });
    }
}
