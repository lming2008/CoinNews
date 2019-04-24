package com.example.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// arouter
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/about/about_main_activity")
public class AboutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_main);
    }
}
