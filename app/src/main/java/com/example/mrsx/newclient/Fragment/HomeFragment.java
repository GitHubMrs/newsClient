package com.example.mrsx.newclient.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mrsx.newclient.R;
import com.example.mrsx.newclient.pager.FristFragment;
import com.example.mrsx.newclient.pager.GovFragment;
import com.example.mrsx.newclient.pager.NewsFragment;
import com.example.mrsx.newclient.pager.SettingFragment;
import com.example.mrsx.newclient.pager.VedioFragment;
import com.example.mrsx.newclient.ui.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import session.slidnglibrary.SlidingMenu;

public class HomeFragment extends Fragment {

    @BindView(R.id.home_pager)
    RadioButton homePager;
    @BindView(R.id.news_pager)
    RadioButton newsPager;
    @BindView(R.id.vedio_pager)
    RadioButton vedioPager;
    @BindView(R.id.gov_pager)
    RadioButton govPager;
    @BindView(R.id.setting_pager)
    RadioButton setting;
    @BindView(R.id.rg)
    RadioGroup rg;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_home, null);

        unbinder = ButterKnife.bind(this, view);
        return view;




    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        homePager.setChecked(true);
        super.onActivityCreated(savedInstanceState);

        getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new FristFragment()).commit();

        HomeActivity homeActivity = (HomeActivity)getActivity();
        final SlidingMenu slidingMenu = homeActivity.getSlidingMenu();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){


                    case R.id.home_pager:

                        getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new FristFragment()).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        break;

                    case R.id.news_pager:
                        getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new NewsFragment()).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;

                    case R.id.vedio_pager:
                       getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new VedioFragment()).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

                        break;

                    case R.id.gov_pager:

                        getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new GovFragment()).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

                        break;


                    case R.id.setting_pager:
                        getChildFragmentManager().beginTransaction().replace(R.id.fl_layout,new SettingFragment()).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);

                        break;


                }
            }
        });

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
