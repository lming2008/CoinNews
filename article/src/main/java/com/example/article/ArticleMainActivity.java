package com.example.article;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// arouter
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/news/article_main_activity")
public class ArticleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_main);
    }
}
