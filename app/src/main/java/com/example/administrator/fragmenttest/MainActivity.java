package com.example.administrator.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new Right_fragment());//动态添加Right_fragment碎片
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();//获取FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启事务
        transaction.replace(R.id.right_layout, fragment);//向容器添加或替换碎片，第一个参数为容器布局ID，第二个为待添加的碎片实例
        transaction.addToBackStack(null);
        transaction.commit();//提交事务
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                replaceFragment(new Another_Right_fragment());
                break;
            default:
                break;
        }

    }
}
