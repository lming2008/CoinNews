package com.example.baselibs;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DataBindingAdapter {

    @BindingAdapter("android:url")
    public static void setImageUrl(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }


}
