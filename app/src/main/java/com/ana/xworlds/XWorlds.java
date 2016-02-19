package com.ana.xworlds;

import android.app.Application;

import com.ana.xworlds.backend.XWorldsApi;
import com.ana.xworlds.utils.Helper;
import com.ana.xworlds.utils.Prefs;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ana on 2/18/2016.
 */
public class XWorlds extends Application {
    private static XWorldsApi xWorldsApi;

    @Override
    public void onCreate() {
        super.onCreate();
        Prefs.getInstance(this).setDeviceId(Helper.getMacAddress(this));
    }

    private static void initRetrofit() {
        // Add the interceptor to OkHttpClient to accept json
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("Accept", "application/json").build();
                return chain.proceed(newRequest);
            }
        });
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(XWorldsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        xWorldsApi = retrofit.create(XWorldsApi.class);
    }

    public static synchronized XWorldsApi getxWorldsApi() {
        if (xWorldsApi == null) {
            initRetrofit();
        }
        return xWorldsApi;
    }
}
