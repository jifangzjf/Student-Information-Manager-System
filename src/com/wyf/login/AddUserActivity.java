package com.wyf.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wyf.Bean.Records;
import com.wyf.dao.RecordsDao;

public class AddUserActivity extends Activity implements OnClickListener {
	private RecordsDao dao = RecordsDao.getInstance(this);
	private Records mrecords;

	private EditText name;
	private EditText number;
	private EditText passwd;
	private EditText age;
	private EditText classname;
	private EditText tel;

	private Button bt_reg, bt_cancel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser);
		name = (EditText) findViewById(R.id.et_name);
		number = (EditText) findViewById(R.id.et_number);
		passwd = (EditText) findViewById(R.id.et_pass);
		age = (EditText) findViewById(R.id.et_age);
		classname = (EditText) findViewById(R.id.et_classname);
		tel = (EditText) findViewById(R.id.et_tel);

		bt_reg = (Button) findViewById(R.id.button_reg);
		bt_cancel = (Button) findViewById(R.id.button_cancel);
		bt_reg.setOnClickListener(this);
		bt_cancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_reg:
			String nameStr = name.getText().toString();
			String numberStr = number.getText().toString();
			String passwdStr = passwd.getText().toString();
			String ageStr = age.getText().toString();
			String classnameStr = classname.getText().toString();
			String telStr = tel.getText().toString();

			// ≤Â»Î ˝æ›
			mrecords = new Records();
			mrecords.setName(nameStr);
			mrecords.setNumber(numberStr);
			mrecords.setPasswd(passwdStr);
			mrecords.setAge(Integer.parseInt(ageStr));
			mrecords.setClassname(classnameStr);
			mrecords.setTel(telStr);
			dao.insert(mrecords);
			Toast.makeText(AddUserActivity.this, R.string.addsuccess,
					Toast.LENGTH_LONG).show();
			finish();
			break;
		case R.id.button_cancel:
			finish();
			break;
		}
	}
}
