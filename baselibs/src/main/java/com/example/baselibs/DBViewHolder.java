package com.example.baselibs;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

public class DBViewHolder extends BaseViewHolder {

    private ViewDataBinding binding;

    public DBViewHolder(View view) {
        super(view);
        if (isBindingView(view)) {
            binding = DataBindingUtil.bind(view);
        }
    }

    public <T> void bindTo(@IdRes int brId, T item) {
        if (null != binding) {
            binding.setVariable(brId, item);
            binding.executePendingBindings();
        }
    }

    private boolean isBindingView(View view) {
        ViewDataBinding binding = DataBindingUtil.getBinding(view);
        if (binding != null) return true;
        Object tag = view.getTag();
        if (tag instanceof String) {
            return ((String) tag).startsWith("layout/");
        }
        return false;
    }
}
