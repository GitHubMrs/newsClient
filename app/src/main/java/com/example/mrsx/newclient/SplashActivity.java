package com.example.mrsx.newclient;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.mrsx.newclient.ui.GuideActivity;
import com.example.mrsx.newclient.ui.HomeActivity;
import com.example.mrsx.newclient.utils.SpUtils;
import com.example.mrsx.newclient.utils.Constant;

public class SplashActivity extends Activity implements View.OnClickListener{

    private VideoView videoView;
    private Button enter_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        initView();
        initVideoView();


    }


    private void initView() {

        videoView = findViewById(R.id.videoview);
        enter_home = findViewById(R.id.enter_home);
        enter_home.setOnClickListener(this);




    }

    private void initVideoView() {

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;

        RelativeLayout.LayoutParams relativeLayout = new RelativeLayout.LayoutParams(widthPixels, heightPixels);
        videoView.setLayoutParams(relativeLayout);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kr36);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Boolean isFrast = SpUtils.getBoolean(SplashActivity.this, Constant.ISFRAST, true);

                if (isFrast) {

                    SpUtils.setBoolean(SplashActivity.this, Constant.ISFRAST,false);


                } else {


                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.enter_home:

            Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
            startActivity(intent);
            finish();
            break;
        }
    }
}
