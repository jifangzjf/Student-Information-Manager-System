package com.wyf.login;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wyf.dao.RecordsDao;

public class LoginActivity extends Activity implements OnClickListener {
	private RecordsDao dao = RecordsDao.getInstance(this);

	private EditText field_number;
	private EditText filed_pass;
	private Button btn1;
	private Button btn2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initUI();
	}

	private void initUI() {
		field_number = (EditText) findViewById(R.id.edit_number);
		filed_pass = (EditText) findViewById(R.id.edit_password);

		btn1 = (Button) findViewById(R.id.bt_login);
		btn2 = (Button) findViewById(R.id.bt_reg);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			login();
			break;
		case R.id.bt_reg:
			register();
			break;
		default:
			break;
		}
	}

	private void login() {
		// name其实是学号
		String number = field_number.getText().toString();
		String pass = filed_pass.getText().toString();

		if (dao.checkLogin(number, pass)) {
			Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT)
					.show();

			// 获取 userId
			Cursor cursor = dao.selectByNumber(number);
			cursor.moveToFirst();
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, UserInfo.class);
			intent.putExtra("userId", id);
			startActivity(intent);
		} else {
			Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT)
					.show();
		}
	}

	private void register() {
		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, AddUserActivity.class);
		startActivity(intent);
	}
}