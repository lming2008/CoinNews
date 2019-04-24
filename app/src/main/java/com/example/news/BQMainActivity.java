package com.example.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// okhttp3
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

// arouter
import com.alibaba.android.arouter.launcher.ARouter;


import static com.example.news.R.string.app_name;
import static com.example.news.R.string.app_subname;
import static com.example.news.R.string.menu_about;
import static com.example.news.R.string.menu_settings;

// article activity

public class BQMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    List<String> mTabLayoutDataList;
    List<Fragment> mFragmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bqmain);

        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(app_name);
        toolbar.setSubtitle(app_subname);
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

        // floating button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //drawer
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //navigation
        NavigationView navigationView = findViewById(R.id.nav_view);

        // action bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        mTabLayout = findViewById(R.id.tablayout);
        mViewPager = findViewById(R.id.viewpager);

        mTabLayoutDataList = new ArrayList<String>();
        mFragmentsList = new ArrayList<Fragment>();
        for (int i = 0; i < 15; i++) {
            mTabLayoutDataList.add("标题"+i);
            mFragmentsList.add(new Fragment());

        }

        mViewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), mTabLayoutDataList, mFragmentsList));
        mTabLayout.setupWithViewPager(mViewPager);

        //
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tab项选中状态时执行
                Log.d("TabLayout","onTabSelected");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab项取消选中状态时执行
                Log.d("TabLayout","onTabUnselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //tab项选中状态再次点击时执行
                Log.d("TabLayout","onTabReselected");
            }

        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 右上角菜单选择器
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Open Setting Activity
            ARouter.getInstance().build("/setting/setting_main_activity")
                    .withString("title", getString(menu_settings))
                    .navigation();
        } else if (id == R.id.action_search) {
            // Open Search Activity
            ARouter.getInstance().build("/search/search_main_activity").navigation();
        }

        return super.onOptionsItemSelected(item);
    }

    // 左上角抽屉菜单选择器
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            ARouter.getInstance().build("/home/home_main_activity").navigation();
            //requestBaidu();
        } else if (id == R.id.nav_collect) {
            // Open Article Activity
            ARouter.getInstance().build("/collect/collect_main_activity").navigation();
        } else if (id == R.id.nav_comments) {
            // Open Comments Activity
            ARouter.getInstance().build("/comments/comments_main_activity").navigation();
        } else if (id == R.id.nav_likes) {
            // Open Likes Activity
            ARouter.getInstance().build("/likes/likes_main_activity").navigation();
        } else if (id == R.id.nav_share) {
            // Open Share Activity
            ARouter.getInstance().build("/share/share_main_activity").navigation();
        } else if (id == R.id.nav_feedback) {
            // Open Feedback Activity
            ARouter.getInstance().build("/feedback/feedback_main_activity").navigation();
        } else if (id == R.id.nav_settings) {
            // Open Setting Activity
            ARouter.getInstance().build("/setting/setting_main_activity").navigation();
        } else if (id == R.id.nav_about) {
            // Open About Activity
            ARouter.getInstance().build("/about/about_main_activity").navigation();
        }

        // 关闭侧边栏
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void requestBaidu() {
        OkHttpClient client = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com")
                .build();
        //通过client发起请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("baidu","failure");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    Log.d("baidu",str);
                }
            }
        });
    }
}
