package com.example.mrsx.newclient.animation;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class RotatePageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {


        int x = page.getWidth()/2;
        int y = page.getHeight();

        if (position<-1){

            page.setRotation(0);

        }else if (position>1){

            page.setRotation(0);

        }else{

            page.setRotation(position*30);
            page.setPivotX(x);
            page.setPivotY(y);
        }

    }
}
