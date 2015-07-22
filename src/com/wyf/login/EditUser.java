package com.wyf.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wyf.Bean.Records;
import com.wyf.dao.RecordsDao;

public class EditUser extends Activity {
	private RecordsDao dao = RecordsDao.getInstance(this);;

	private EditText et_name;
	private EditText et_number;
	private EditText et_passwd;
	private EditText et_age;
	private EditText et_classname;
	private EditText et_tel;
	private Button btn;

	private int userId;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edituser);

		Intent intent = getIntent();
		userId = intent.getIntExtra("userId", 0);

		et_name = (EditText) findViewById(R.id.et_name);
		et_number = (EditText) findViewById(R.id.et_number);
		et_passwd = (EditText) findViewById(R.id.et_passwd);
		et_age = (EditText) findViewById(R.id.et_age);
		et_tel = (EditText) findViewById(R.id.et_tel);
		et_classname = (EditText) findViewById(R.id.et_classname);
		btn = (Button) findViewById(R.id.bt_update);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Records mrecords = new Records();
				//mrecords.setId(userId);
				mrecords.setName(et_name.getText().toString());
				mrecords.setNumber(et_number.getText().toString());
				mrecords.setPasswd(et_passwd.getText().toString());
				mrecords.setAge(Integer.parseInt(et_age.getText().toString()));
				mrecords.setClassname(et_classname.getText().toString());
				mrecords.setTel(et_tel.getText().toString());

				if (dao.update(mrecords, userId) > 0)
					Toast.makeText(EditUser.this, R.string.updatesuccess,
							Toast.LENGTH_LONG).show();
				else
					Toast.makeText(EditUser.this, "¸üÐÂÊ§°Ü", Toast.LENGTH_LONG)
							.show();
				 Intent intent = new Intent(EditUser.this, UserInfo.class);
				 intent.putExtra("userId", userId);
				 startActivity(intent);
			}
		});
	}
}
