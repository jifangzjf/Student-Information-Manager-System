package com.wyf.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PrefaceActivity extends Activity implements OnClickListener {
	private Button button1;
	private Button button2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preface_activity);
		button1 = (Button) findViewById(R.id.loginButton1);
		button2 = (Button) findViewById(R.id.loginButton2);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 学生用户登录
		case R.id.loginButton1:
			Intent student = new Intent(this, LoginActivity.class);
			startActivity(student);
			finish();

			// 教师登录
		case R.id.loginButton2:
//			Intent intent = new Intent(this, StudentList.class);
//			startActivity(intent);
//			finish();
			break;
		default:
			break;

		}

	}

}
