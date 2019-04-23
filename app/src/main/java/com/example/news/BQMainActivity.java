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

// activitys
import com.example.about.AboutMainActivity;
import com.example.article.ArticleMainActivity;
import com.example.search.SearchMainActivity;
import com.example.setting.SettingMainActivity;

import static com.example.news.R.string.app_name;
import static com.example.news.R.string.app_subname;

// article activity

public class BQMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        List<String> titles = Arrays.asList("AAA", "BBBB");
        List<Fragment> fragments = Arrays.asList(new Fragment(), new Fragment());
        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), titles, fragments));
        tabLayout.setupWithViewPager(viewPager);
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
            Intent intent = new Intent(getApplicationContext(), SettingMainActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_search) {
            // Open Share Activity
            ARouter.getInstance().build("/news/search_main_activity").navigation();

//            Intent intent = new Intent(getApplicationContext(), SearchMainActivity.class);
//            startActivity(intent);
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
            requestBaidu();
        } else if (id == R.id.nav_gallery) {
            // Open Article Activity
            Intent intent = new Intent(getApplicationContext(), ArticleMainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_settings) {
            // Open Settings Activity
            Intent intent = new Intent(getApplicationContext(), SettingMainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            // Open About Activity
            Intent intent = new Intent(getApplicationContext(), AboutMainActivity.class);
            startActivity(intent);
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
