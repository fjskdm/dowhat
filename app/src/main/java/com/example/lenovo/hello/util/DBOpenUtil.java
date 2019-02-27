package com.example.lenovo.hello.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lenovo.hello.StoreActivity;

public class DBOpenUtil extends SQLiteOpenHelper {

//    使用SQLite的基本步骤(插入)
//    DBOpenUtil dbOpenUtil = new DBOpenUtil(xx.this,"xx"(保存的文件名称),null,1(版本号));
//    SQLiteDatabase database = dbOpenUtil.getReadableDatabase();
//    ContentValues contentValues = new ContentValues();
//    contentValues.put(""(变量名),(变量值));
//    database.insert(""(插入的表名),null,contentValues);

    final String CREATE_TABLE_SQL="create table tb_main (_id integer primary key autoincrement,name,pass)";//创建SQLite数据表

    public DBOpenUtil(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {//使用本构造函数传入的name是数据库文件的名字，数据库中表的名字是在SQL语句中提供的
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("servion","版本更新："+oldVersion+" --> "+newVersion);
    }
}
