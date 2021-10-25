package com.example.mywork_zzx;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class txl_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mList = new ArrayList<>();
    private Context context;
    private adapter_expand adapter;

    public txl_Fragment() {
        // Required empty public constructor
    }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view= inflater.inflate(R.layout.tab03, container, false);

            recyclerView=view.findViewById(R.id.rcv_expandcollapse);
            initexpandData();
            initView();

            return view;
        }
        private void initexpandData(){
            mList.add("宋心怡");
            mList.add("孙江倩");
            mList.add("王亚腾");
            mList.add("李森昊");
            mList.add("林一");
            mList.add("王嘉尔");
            mList.add("关晓彤");
            mList.add("陈飞宇");
            mList.add("赵丽颖");
            mList.add("杨颖");
            mList.add("大张伟");
        }

        private void initView(){
            context=this.getActivity();
            adapter=new adapter_expand(context,mList);

            LinearLayoutManager manager=new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(manager);
            recyclerView.setHasFixedSize(true);
            recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        }
    }
