package com.example.setting;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibs.BaseActivity;

@Route(path = "/setting/setting_main_activity")
public class SettingMainActivity extends BaseActivity {

    @Autowired(name = "title")
    public  String titleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);

        setContentView(R.layout.activity_setting_main);

//        getSupportActionBar().setTitle(titleString);
        TextView titleTextView = findViewById(R.id.tv_title);
        titleTextView.setText(titleString);

        ImageButton backButton = findViewById(R.id.tv_imagebutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("back","back");
                finish();
            }
        });
    }

    public void backAction() {

    }
}
