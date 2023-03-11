package com.youknowwho.androidclient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestUserInfo {
    @GET("users/{id}/")
    Call<UserInfo> user(@Path("id") int id);
}
