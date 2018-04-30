package com.map.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 创建时间： 2018/4/30
 * 编写人：Administrator
 * 功能描述：
 */
public class SQLiteOperate {
    private static SQLiteOperate instance = new SQLiteOperate();

    private SQLiteOperate() {
    }

    public static SQLiteOperate newInstance() {
        return instance;
    }

    /**
     * 创建数据库
     *
     * @param context
     */
    private void create(Context context) {
        //创建StuDBHelper对象
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 1);
        //得到一个可读的SQLiteDatabase对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }

    private void update(Context context) {
        // 数据库版本的更新,由原来的1变为2
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }

    /**
     * 增加一条记录
     *
     * @param context
     * @param id
     * @param title
     * @param content
     * @param picture
     * @param album
     * @param type1
     * @param type2
     * @param createname
     * @param createtime
     */
    private void insert(Context context, int id, String title, String content, String picture, String album, Integer type1, Integer type2, String createname, long createtime) {
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 1);
        //得到一个可写的数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //生成ContentValues对象 //key:列名，value:想插入的值
        ContentValues cv = new ContentValues();
        //往ContentValues对象存放数据，键-值对模式
        cv.put("id", id);
        cv.put("title", title);
        cv.put("content", content);
        cv.put("picture", picture);
        cv.put("album", album);
        cv.put("type1", type1);
        cv.put("type2", type2);
        cv.put("createname", createname);
        cv.put("createtime", createtime);
        //调用insert方法，将数据插入数据库
        db.insert("stu_table", null, cv);
        //关闭数据库
        db.close();

    }

    /**
     * 查询数据库
     *
     * @param context
     * @param id
     */
    private void query(Context context, int id) {
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 1);
        //得到一个可写的数据库
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //参数1：表名
        //参数2：要想显示的列
        //参数3：where子句
        //参数4：where子句对应的条件值
        //参数5：分组方式
        //参数6：having条件
        //参数7：排序方式
        Cursor cursor = db.query("stu_table", new String[]{"id", "title", "content", "picture", "album", "type1", "type2", "createname", "createtime"}, "id=?", new String[]{id + ""}, null, null, null);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            String picture = cursor.getString(cursor.getColumnIndex("picture"));
            String album = cursor.getString(cursor.getColumnIndex("album"));
            String type1 = cursor.getString(cursor.getColumnIndex("type1"));
            String type2 = cursor.getString(cursor.getColumnIndex("type2"));
            String createname = cursor.getString(cursor.getColumnIndex("createname"));
            String createtime = cursor.getString(cursor.getColumnIndex("createtime"));
            System.out.println("query------->" + "标题：" + title + "内容：" + content + "图片：" + picture + "相册：" + album + "分类1：" + type1 + "分类2:" + type2 + "createname:" + createname + "createtime:" + createtime);
        }
        //关闭数据库
        db.close();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param id
     */
    private void update(Context context, int id, String title, String content, String picture, String album, Integer type1, Integer type2, String createname, long createtime) {
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 1);
        //得到一个可写的数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //生成ContentValues对象 //key:列名，value:想插入的值
        ContentValues cv = new ContentValues();
        //往ContentValues对象存放数据，键-值对模式
        cv.put("id", id);
        cv.put("title", title);
        cv.put("content", content);
        cv.put("picture", picture);
        cv.put("album", album);
        cv.put("type1", type1);
        cv.put("type2", type2);
        cv.put("createname", createname);
        cv.put("createtime", createtime);
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(id)};
        //参数1 是要更新的表名
        //参数2 是一个ContentValeus对象
        //参数3 是where子句
        db.update("stu_table", cv, whereClause, whereArgs);
        //关闭数据库
        db.close();
    }

    private void delete(Context context, int id) {
        PicDBHelper dbHelper = new PicDBHelper(context, "stu_db", null, 1);
        //得到一个可写的数据库
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String whereClauses = "id=?";
        String[] whereArgs = {String.valueOf(id)};
        //调用delete方法，删除数据
        db.delete("stu_table", whereClauses, whereArgs);
    }
}
