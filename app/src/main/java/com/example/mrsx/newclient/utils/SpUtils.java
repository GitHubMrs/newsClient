package com.example.mrsx.newclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {


    private static SharedPreferences sp;

    public static Boolean getBoolean(Context context, String key, Boolean defValue) {

        if (sp == null) {
            sp = context.getSharedPreferences("index", Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, Boolean defValue) {

        if (sp == null) {
            sp = context.getSharedPreferences("index", Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, defValue).commit();

    }


}
