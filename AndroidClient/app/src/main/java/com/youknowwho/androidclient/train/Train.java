package com.youknowwho.androidclient.train;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Train {
    private final Retrofit retrofit = new Retrofit
            .Builder()
            // https://developer.android.com/studio/run/emulator-networking#networkaddresses
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Task getTask() throws IOException {
        GetTask get = retrofit.create(GetTask.class);
        Call<Task> call = get.task();
        return call.execute().body();
    }

    public Empty postData() throws IOException {
        PostData post = retrofit.create(PostData.class);
        UploadData uploadData = new UploadData(
                0, Instant.now().getEpochSecond(), 0.452, Arrays.asList(0.0, 24.0, 5.0), 34.542);
        Call<Empty> empty = post.result(uploadData);
        return empty.execute().body();
    }
}
