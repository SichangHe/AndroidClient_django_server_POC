package com.youknowwho.androidclient.train;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Train {
    private final Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl("http://127.0.0.1:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Task getTask() throws IOException {
        GetTask get = retrofit.create(GetTask.class);
        Call<Task> call = get.task();
        return call.execute().body();
    }
}
