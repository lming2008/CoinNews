package com.example.share;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// arouter
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/news/share_main_activity")
public class ShareMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_main);
    }
}
