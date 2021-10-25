package com.example.mywork_zzx;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class friend_Fragment extends Fragment implements adapter.OnItemClickListener {

    private static final String TAG = friend_Fragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private TextView tvArea;
    private List<String> mList = new ArrayList<>();
    private List<StickyData> mDataList = new ArrayList<>();
    private Context context;
    private adapter adapter;

    public friend_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.tab02, container, false);
        context = view.getContext();

        recyclerView=view.findViewById(R.id.recycleview);
        tvArea=view.findViewById(R.id.tv_sticky_header_view);

        initList();
        initData();
        initView();

        return view;
    }
    private void initList() {
        mList.add("亲友|李森昊");

        mList.add("密友|宋心怡");
        mList.add("密友|孙江倩");
        mList.add("密友|王亚腾");

        mList.add("同学|林一");
        mList.add("同学|王嘉尔");
        mList.add("同学|关晓彤");
        mList.add("同学|陈飞宇");
        mList.add("同学|赵丽颖");
        mList.add("同学|杨颖");
        mList.add("同学|邢菲");
        mList.add("同学|任嘉伦");
        mList.add("同学|李荣浩");
        mList.add("同学|刘志");
        mList.add("同学|王雨");
        mList.add("同学|黄五");
        mList.add("同学|刘美岐");
        mList.add("同学|袁永琪");
        mList.add("同学|廉小龙");
        mList.add("同学|赵孟伟");
        mList.add("同学|李丑");
        mList.add("同学|张美");
        mList.add("同学|王帅");
        mList.add("同学|李二");
    }

    private void initData() {
        for (int i = 0; i < mList.size(); i++) {
            StickyData bean = new StickyData();

            String s = mList.get(i);
            // area
            String area = s.substring(0, s.indexOf("|"));
            // team
            String team = s.substring(s.indexOf("|") + 1, s.length());

            bean.setArea(area);
            bean.setTeam(team);

            mDataList.add(bean);
        }

        Log.d(TAG, "initData: " + mDataList.size());
    }

    private void initView() {
        context=this.getActivity();
        adapter=new adapter(context,mDataList);

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                View stickyInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvArea.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                View transInfoView = recyclerView.findChildViewUnder(
                        tvArea.getMeasuredWidth() / 2, tvArea.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {

                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvArea.getMeasuredHeight();

                    if (transViewStatus == adapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvArea.setTranslationY(dealtY);
                        } else {
                            tvArea.setTranslationY(0);
                        }
                    } else if (transViewStatus == adapter.NONE_STICKY_VIEW) {
                        tvArea.setTranslationY(0);
                    }
                }
            }
        });
    }
    @Override
    public void onItemClick(String content) {
        Toast.makeText(context, "这是 " + content, Toast.LENGTH_SHORT).show();
    }
}
