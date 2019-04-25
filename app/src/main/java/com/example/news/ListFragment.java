package com.example.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.baselibs.BaseFragment;
import com.example.baselibs.DBViewHolder;

import java.util.Arrays;

public class ListFragment extends BaseFragment {


    private RecyclerView recyclerView;
    private BaseQuickAdapter<String, DBViewHolder> adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycleView);

        adapter = new BaseQuickAdapter<String, DBViewHolder>(R.layout.item_list_string) {
            @Override
            protected void convert(DBViewHolder holder, String item) {
                holder.bindTo(BR.item, item);
            }

            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }
        };
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);

        adapter.replaceData(Arrays.asList("A", "B", "C", "D", "E", "F", "H", "I"));
    }
}
