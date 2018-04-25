package com.map.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Pic;
import com.utils.NetWorkUtils;

public class MainActivity extends AppCompatActivity {
    String jsonArray = "[{id:\"title\",content:\"content\",mainpicture:\"mainpicture\",albumid:\"album\",class1:\"class1\",class2:\"class2\",createname:\"createname\",createtime:\"createtime\"},{id:\"title\",content:\"content\",mainpicture:\"mainpicture\",albumid:\"album\",class1:\"class1\",class2:\"class2\",createname:\"createname\",createtime:\"createtime\"}]\n";
    SharedPreferences mSharedPreferences = getSharedPreferences("pic", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parse();

        if (jsonArray != null && jsonArray.length() != 0) {//保存数据

            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putString("jsonArray", jsonArray);
            editor.commit();
        }


        boolean isnetwork = NetWorkUtils.isConnect(MainActivity.this);
        if (!isnetwork) {
            String jsonArray = mSharedPreferences.getString("jsonArray", "");//无网情况下使用本地缓存的数据
        }
    }

    /**
     * JsonArray转换成对象
     */
    private void parse() {
        JSONArray arrayList = JSON.parseArray(jsonArray);
        for (Object jsonObject : arrayList) {
            JSONObject.parseObject(jsonObject.toString(), Pic.class);
        }
    }


}
