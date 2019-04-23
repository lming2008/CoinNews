package com.example.collect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// arouter
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/news/collect_main_activity")
public class CollectMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_main);
    }
}
