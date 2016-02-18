package com.ana.xworlds.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Ana on 2/18/2016.
 */
public class Prefs {
    private static Prefs instance;
    private Context context;
    private SharedPreferences prefs;

    private interface K {
        String deviceId = "deviceId";
    }

    public static synchronized Prefs getInstance(Context context) {
        if (instance == null) {
            instance = new Prefs(context);
        }
        return instance;
    }

    private Prefs(Context context) {
        this.context = context;
        this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setDeviceId(String deviceId) {
        prefs.edit().putString(K.deviceId, deviceId).apply();
    }

    public String getDeviceId() {
        return prefs.getString(K.deviceId, "");
    }
}
