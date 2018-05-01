package com.map.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建时间： 2018/4/30
 * 编写人：Administrator
 * 功能描述：
 */
public class PicDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "TestSQLite";
    public static final int VERSION = 1;

    //必须要有构造函数
    public PicDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    private Integer id;
    private String title;
    private String content;
    private String picture;
    private String album;
    private Integer type1;
    private Integer type2;
    private String createname;
    private long createtime;


    // 当第一次创建数据库的时候，调用该方法
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table stu_table(id int,title varchar(20),content varchar(50),picture varchar(20),album varchar(20),type1 int,type2 int,createname varchar(20),createtime long)";
//execSQL函数用于执行SQL语句
        db.execSQL(sql);
    }

    //当更新数据库的时候执行该方法
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//输出更新数据库的日志信息

    }
}
