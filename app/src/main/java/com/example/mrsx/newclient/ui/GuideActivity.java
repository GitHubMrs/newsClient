package com.example.mrsx.newclient.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mrsx.newclient.R;
import com.example.mrsx.newclient.SplashActivity;
import com.example.mrsx.newclient.animation.RotatePageTransformer;
import com.example.mrsx.newclient.animation.ZoomOutPageTransformer;

public class GuideActivity extends Activity implements View.OnClickListener{

    private ViewPager view_pager;

    private LinearLayout container_point;
    private ImageView red_point;

    private Button go_home;

    private int width;

    final int imageRes[] = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        initViewPager();

        initView();


        red_point.post(new Runnable() {
            @Override
            public void run() {
                width = red_point.getMeasuredWidth();
                Log.i("aaa", "================================" + width);
            }
        });



    }


    private void initView() {


        red_point = findViewById(R.id.red_point);


        container_point = findViewById(R.id.container_point);
        container_point.removeAllViews();


        go_home = findViewById(R.id.go_home);
        go_home.setOnClickListener(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);


        for (int i = 0; i < imageRes.length; i++) {

            ImageView imageView = new ImageView(GuideActivity.this);

            imageView.setBackgroundResource(R.drawable.sharp_dark_point);

            layoutParams.setMargins(0, 0, 10, 0);

            container_point.addView(imageView, layoutParams);

        }

    }

    public void initViewPager() {

        view_pager = findViewById(R.id.view_pager);
        view_pager.setAdapter(new MeViewPagerAdapter());
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int moveX = (int) ((width + 10) * (positionOffset + position));

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

                params.leftMargin = moveX;

                red_point.setLayoutParams(params);


            }

            @Override
            public void onPageSelected(int position) {

                if (position==imageRes.length-1)
                    go_home.setVisibility(View.VISIBLE);
                else go_home.setVisibility(View.GONE);



            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        view_pager.setPageTransformer(true, new RotatePageTransformer());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(GuideActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }


    class MeViewPagerAdapter extends PagerAdapter {


        //向ViewPaget里面添加界面

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {


            ImageView imageView = new ImageView(GuideActivity.this);


            imageView.setBackgroundResource(imageRes[position]);


            container.addView(imageView);

            return imageView;
        }


        //从viewpaget里面移除界面


        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View) object);

        }

        @Override
        public int getCount() {
            return imageRes.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }


}
