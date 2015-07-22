package com.wyf.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DataBaseHelper extends SQLiteOpenHelper {

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUME_NUMBER = "number";
	public static final String COLUMN_PASSWD = "passwd";
	public static final String COLUMN_AGE = "age";
	public static final String COLUMN_CLASSNAME = "class";
	public static final String COLUMN_TEL = "tel";

	private static final String DATABASE_NAME = "Student.db";
	public static final String TABLE_NAME = "student";

	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ COLUMN_NAME + " TEXT," + COLUME_NUMBER + " TEXT,"
				+ COLUMN_PASSWD + " TEXT," + COLUMN_AGE + " INTEGER,"
				+ COLUMN_CLASSNAME + " TEXT," + COLUMN_TEL + " TEXT)";
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + TABLE_NAME);
		
		String SQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ COLUMN_NAME + " TEXT," + COLUME_NUMBER + " TEXT,"
				+ COLUMN_PASSWD + " TEXT," + COLUMN_AGE + " INTEGER,"
				+ COLUMN_CLASSNAME + " TEXT," + COLUMN_TEL + " TEXT)";
		db.execSQL(SQL);
	}
}
