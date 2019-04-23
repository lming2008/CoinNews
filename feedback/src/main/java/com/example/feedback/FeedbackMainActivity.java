package com.example.feedback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// arouter
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/news/feedback_main_activity")
public class FeedbackMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_main);
    }
}
