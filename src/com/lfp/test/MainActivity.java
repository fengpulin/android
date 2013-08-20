package com.lfp.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText editText_getName;
	
	private Button button_Login;
	
	private TextView textView_showLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText_getName = (EditText)findViewById(R.id.editText_getName);
        
        button_Login = (Button)findViewById(R.id.button_login);
        
        textView_showLogin = (TextView)findViewById(R.id.textView_showLogin);
        
        button_Login.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		textView_showLogin.setText("hello"+editText_getName.getText());
        	}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
