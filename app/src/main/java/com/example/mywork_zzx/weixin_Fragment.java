package com.example.mywork_zzx;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class weixin_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> mList = new ArrayList<>();
    private Context context;
    private adapter_swipe adapter;



    public weixin_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tab01, container, false);

        recyclerView=view.findViewById(R.id.rcv_swipe);
        initData();
        initView();

        return view;
    }
    private void initData() {
        mList.add("宋心怡");
        mList.add("王亚腾");
        mList.add("孙江倩");
        mList.add("李森昊");
    }

    private void initView(){
        context=this.getActivity();
        adapter=new adapter_swipe(context,mList);

        ItemTouchHelper.Callback callback = new SwipeItemTouchHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
    }



}