package com.jpr.jiao.other;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jpr.jiao.R;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-03-08
 * 邮箱：jiaopeirong@xiaomi.com
 */
public class StringActivity extends AppCompatActivity {
    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
        TextView tv0 = findViewById(R.id.tv0);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv33 = findViewById(R.id.tv33);
        TextView tv4 = findViewById(R.id.tv4);
        TextView tv5 = findViewById(R.id.tv5);
        TextView tv6 = findViewById(R.id.tv6);
        TextView tv7 = findViewById(R.id.tv7);
        TextView tv8 = findViewById(R.id.tv8);

        //获取string.xml和data_string.xml
        tv0.setText("string.xml："+getResources().getString(R.string.string0));
        tv1.setText("data_string.xml:"+getResources().getString(R.string.data_string0));

        //单个匹配
        tv2.setText(String.format(getResources().getString(R.string.string1),"中国"));
        tv3.setText(String.format(getResources().getString(R.string.string2),14));


        //多个匹配
        tv33.setText(String.format(getResources().getString(R.string.string33,7,1,"塔尔堡小学")));
        tv4.setText(String.format(getResources().getString(R.string.string3 , 7,1,"红星小学")));
        tv5.setText(String.format(getResources().getString(R.string.string4 , 7,1,"庐山小学")));
        tv6.setText(String.format(getResources().getString(R.string.string5 , 7,1,"浏阳小学")));

        //单复数匹配(中文不区分)
        tv7.setText(getResources().getQuantityString(R.plurals.string6,1,4));
        tv8.setText(String.format(getResources().getQuantityString(R.plurals.string6,5),5));


    }
}
