package com.example.mrsx.newclient.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.example.mrsx.newclient.Fragment.HomeFragment;
import com.example.mrsx.newclient.R;

import session.slidnglibrary.SlidingMenu;
import session.slidnglibrary.app.SlidingActivity;
import session.slidnglibrary.app.SlidingFragmentActivity;

public class HomeActivity extends SlidingFragmentActivity {

    private FrameLayout fl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fl = (FrameLayout) findViewById(R.id.fl);

        HomeFragment fragment = new HomeFragment();

         getFragmentManager().beginTransaction().replace(R.id.fl,fragment).commit();


        //获取slingMenu对象
        SlidingMenu slidingMenu = getSlidingMenu();

        //设置slingMenu布局背景
        setBehindContentView(R.layout.left_menu);
        //指定侧拉菜单宽度
        slidingMenu.setBehindWidth(400);

        //指定侧拉菜单方向(位置)
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置右侧布局
        //slidingMenu.setSecondaryMenu();


        //设置侧拉菜单的分割线
        slidingMenu.setShadowDrawable(R.drawable.sharp_slingmenu);
        slidingMenu.setShadowWidth(40);

        //设置侧拉菜单的拖拽区域
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);


    }
}
