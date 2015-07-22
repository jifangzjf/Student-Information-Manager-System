package com.wyf.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wyf.dao.RecordsDao;

public class UserInfo extends Activity implements OnClickListener {
	private TextView et_id;
	private TextView et_name;
	private TextView et_number;
	private TextView et_passwd;
	private TextView et_age;
	private TextView et_classname;
	private TextView et_tel;

	private Button btn1;
	private Button btn2;

	private RecordsDao dao = RecordsDao.getInstance(this);
	private int id;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfo);

		Intent intent = getIntent();
		id = intent.getIntExtra("userId", 0);

		initUI();
		disInformation(id);
	}

	private void initUI() {
		et_id = (TextView) findViewById(R.id.et_id);
		et_name = (TextView) findViewById(R.id.et_name);
		et_number = (TextView) findViewById(R.id.et_number);
		et_passwd = (TextView) findViewById(R.id.et_passwd);
		et_age = (TextView) findViewById(R.id.et_age);
		et_classname = (TextView) findViewById(R.id.et_classname);
		et_tel = (TextView) findViewById(R.id.et_tel);

		btn1 = (Button) findViewById(R.id.bt_update);
		btn2 = (Button) findViewById(R.id.bt_exit);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
	}

	private void disInformation(int id) {
		Cursor mCursor = dao.selectById(id);
		mCursor.moveToFirst();
		et_id.setText(mCursor.getInt(mCursor.getColumnIndex("id")) + "");
		et_name.setText(mCursor.getString(1));
		et_number.setText(mCursor.getString(2));
		et_passwd.setText(mCursor.getString(3));
		et_age.setText(mCursor.getString(4));
		et_classname.setText(mCursor.getString(5));
		et_tel.setText(mCursor.getString(6));
		mCursor.close();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_update:
			Intent intent1 = new Intent(UserInfo.this, EditUser.class);
			intent1.putExtra("usrId", id);
			startActivity(intent1);
			finish();
			break;
		case R.id.bt_exit:
			Intent intent2 = new Intent(UserInfo.this, LoginActivity.class);
			startActivity(intent2);
			finish();
			break;
		default:
			break;
		}
	}
}
