package com.toy.key.cjni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.toy.key.cjni.JNIHelper.registerListener;
import static com.toy.key.cjni.JNIHelper.stringFromJNI;
//实现接口NativeListener
public class MainActivity extends AppCompatActivity implements NativeListener {



    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.sample_text);
        //绑定监听
        registerListener(this);
    }

    public void onViewClick(View view) {
        //调用c库的stringFromJNI方法获取返回值并从Toast中显示
        String str = stringFromJNI();
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeText(String msg) {//实现接口NativeListener 的chaneText方法。修改文字
        tv.setText(msg);
    }

}
