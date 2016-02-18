package com.ana.xworlds.remote;

import com.ana.xworlds.entity.GetAllWorldsResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ana on 2/18/2016.
 */
public interface XWorldsApi {
    String BASE_URL = "http://backend1.lordsandknights.com";

    @POST("/XYRALITY/WebObjects/BKLoginServer.woa/wa/worlds")
    Call<GetAllWorldsResponse> loginAndGetWorlds2(
            @Query("login") String login,
            @Query("password") String password,
            @Query("deviceType") String deviceType,
            @Query("deviceId") String deviceId);
}
