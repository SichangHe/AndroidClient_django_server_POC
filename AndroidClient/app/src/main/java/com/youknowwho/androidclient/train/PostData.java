package com.youknowwho.androidclient.train;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostData {
    @POST("train/")
    Call<Empty> result(@Body UploadData uploadData);
}
