package com.example.mywork_zzx;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import static com.example.mywork_zzx.R.id.action_bar;
import static com.example.mywork_zzx.R.id.id_content;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment mtab01 = new weixin_Fragment();
    private Fragment mtab02 = new friend_Fragment();
    private Fragment mtab03 = new txl_Fragment();
    private Fragment mtab04 = new setting_Fragment();
    private FragmentManager fm;
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabContact;
    private LinearLayout mTabSettings;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgContact;
    private ImageButton mImgSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar action_bar=getSupportActionBar();
        if(action_bar!=null)
            action_bar.hide();/*隐藏activity头*/
        setContentView(R.layout.activity_main);
        initFragment();
        initview();
        setselect(0);
        initEvent();
    }
    private void initFragment(){
        fm =getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.add(R.id.id_content,mtab01);
        transaction.add(R.id.id_content,mtab02);
        transaction.add(R.id.id_content,mtab03);
        transaction.add(R.id.id_content,mtab04);
        transaction.commit();
    }
    private void initview(){
        mTabWeixin=(LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd=(LinearLayout)findViewById(R.id.id_tab_frd);
        mTabContact=(LinearLayout)findViewById(R.id.id_tab_txl);
        mTabSettings=(LinearLayout)findViewById(R.id.id_tab_setting);

        mImgWeixin=(ImageButton)findViewById(R.id.weixin_img);
        mImgFrd=(ImageButton)findViewById(R.id.frd_img);
        mImgContact=(ImageButton)findViewById(R.id.txl_img);
        mImgSettings=(ImageButton)findViewById(R.id.settong_img);
    }
    private void setselect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(mtab01);
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mtab02);
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mtab03);
                mImgContact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mtab04);
                mImgSettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(mtab01);
        transaction.hide(mtab02);
        transaction.hide(mtab03);
        transaction.hide(mtab04);
    }

    @Override
    public void onClick(View view) {
        resetImgs();
        switch(view.getId())
        {
            case R.id.id_tab_weixin:
                setselect(0);
                break;
            case R.id.weixin_img:
                setselect(0);
                break;
            case R.id.id_tab_frd:
                setselect(1);
                break;
            case R.id.frd_img:
                setselect(1);
                break;
            case R.id.id_tab_txl:
                setselect(2);
                break;
            case R.id.txl_img:
                setselect(2);
                break;
            case R.id.id_tab_setting:
                setselect(3);
                break;
            case R.id.settong_img:
                setselect(3);
                break;
            default:
                break;
        }
    }
    private void resetImgs(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgContact.setImageResource(R.drawable.tab_address_normal);
        mImgSettings.setImageResource(R.drawable.tab_settings_normal);
    }
    private void initEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
        mTabSettings.setOnClickListener(this);
        mImgWeixin.setOnClickListener(this);
        mImgFrd.setOnClickListener(this);
        mImgContact.setOnClickListener(this);
        mImgSettings.setOnClickListener(this);
    }
}