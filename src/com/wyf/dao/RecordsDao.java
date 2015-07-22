package com.wyf.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wyf.Bean.Records;

public class RecordsDao {

	private DataBaseHelper mdbhelper;
	private SQLiteDatabase db;

	private static RecordsDao mrecordsDao;

	private RecordsDao(Context context) {
		mdbhelper = new DataBaseHelper(context, null, null, 0);
	}

	public void closeAll() {
		mdbhelper.close();
		db.close();
	}

	public static RecordsDao getInstance(Context context) {
		if (mrecordsDao == null) {
			mrecordsDao = new RecordsDao(context);
			return mrecordsDao;
		}
		return mrecordsDao;
	}

	// 验证用户登录
	public boolean checkLogin(String username, String password) {
		db = mdbhelper.getWritableDatabase();
		Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, null, "number = ?",
				new String[] { username }, null, null, null);
		cursor.moveToFirst();
		String passwdFromDb = cursor.getString(cursor.getColumnIndex("passwd"));
		if (passwdFromDb.equals(password))
			return true;
		return false;
	}

	// 增
	public void insert(Records r) {
		db = mdbhelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(DataBaseHelper.COLUMN_NAME, r.getName());
		cv.put(DataBaseHelper.COLUME_NUMBER, r.getNumber());
		cv.put(DataBaseHelper.COLUMN_PASSWD, r.getPasswd());
		cv.put(DataBaseHelper.COLUMN_AGE, r.getAge());
		cv.put(DataBaseHelper.COLUMN_CLASSNAME, r.getClassname());
		cv.put(DataBaseHelper.COLUMN_TEL, r.getTel());
		db.insert(DataBaseHelper.TABLE_NAME, null, cv);
	}

	// 删
	public void delete(int id) {
		db = mdbhelper.getWritableDatabase();
		db.delete(DataBaseHelper.TABLE_NAME, "id = ?", new String[] { id + "" });
	}

	// 改
	public int update(Records r, int id) {
		db = mdbhelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(DataBaseHelper.COLUMN_NAME, r.getName());
		cv.put(DataBaseHelper.COLUME_NUMBER, r.getNumber());
		cv.put(DataBaseHelper.COLUMN_PASSWD, r.getPasswd());
		cv.put(DataBaseHelper.COLUMN_AGE, r.getAge());
		cv.put(DataBaseHelper.COLUMN_CLASSNAME, r.getClassname());
		cv.put(DataBaseHelper.COLUMN_TEL, r.getTel());
		return db.update(DataBaseHelper.TABLE_NAME, cv, "id = ?",
				new String[] { id + "" });
	}

	// 查
	public Cursor selectById(int id) {
		db = mdbhelper.getWritableDatabase();
		Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, null, "id = ?",
				new String[] { id + "" }, null, null, null);
		return cursor;
	}

	// 查
	public Cursor selectByNumber(String number) {
		db = mdbhelper.getWritableDatabase();
		Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, null, "number = ?",
				new String[] { number }, null, null, null);
		return cursor;
	}

	public void execSQL(String sql) {
		db = mdbhelper.getWritableDatabase();
		db.execSQL(sql);
	}
}
