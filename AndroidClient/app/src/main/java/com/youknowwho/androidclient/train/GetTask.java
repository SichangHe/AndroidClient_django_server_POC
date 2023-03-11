package com.youknowwho.androidclient.train;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetTask {
    @GET("train/task")
    Call<Task> task();
}
