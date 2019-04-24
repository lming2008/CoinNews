package com.example.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/setting/setting_main_activity")
public class SettingMainActivity extends AppCompatActivity {

    @Autowired(name = "title")
    public  String titleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        ARouter.getInstance().inject(this);

        setContentView(R.layout.activity_setting_main);

        getSupportActionBar().setTitle(titleString);
    }
}
