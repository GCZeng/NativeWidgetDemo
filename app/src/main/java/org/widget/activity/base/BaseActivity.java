package org.widget.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nick on 2017/4/12
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int providerLayout();

    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(providerLayout());

        initView();
        initData();
    }

    protected void goActivity(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }

    protected void goActivity(Class clazz,Bundle bundle){
        Intent intent = new Intent(this,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
