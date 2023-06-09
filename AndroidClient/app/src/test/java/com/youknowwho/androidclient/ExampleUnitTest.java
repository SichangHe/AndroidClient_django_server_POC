package com.youknowwho.androidclient;

import static com.youknowwho.androidclient.GreetKotlinKt.greetKotlin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youknowwho.androidclient.train.Empty;
import com.youknowwho.androidclient.train.GetTask;
import com.youknowwho.androidclient.train.PostData;
import com.youknowwho.androidclient.train.Task;
import com.youknowwho.androidclient.train.UploadData;

import org.junit.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Retrofit retrofit = new Retrofit
            .Builder()
            .baseUrl("http://127.0.0.1:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    @Test
    public void greetKotlin_works() {
        greetKotlin();
    }

    /**
     * Test requesting user info.
     * Requires Django server running.
     */
    @Test
    public void requestUserInfo_works() throws IOException {
        RequestUserInfo request = retrofit.create(RequestUserInfo.class);
        Call<UserInfo> call = request.user(1);
        UserInfo user = call.execute().body();
        System.out.println(gson.toJson(user));
    }

    /**
     * Test getting a task.
     * Requires Django server running.
     */
    @Test
    public void getTask_works() throws IOException {
        GetTask get = retrofit.create(GetTask.class);
        Call<Task> call = get.task();
        Task task = call.execute().body();
        System.out.println(gson.toJson(task));
    }

    /**
     * Test posting data.
     * Requires Django server running.
     */
    @Test
    public void postData_works() throws IOException {
        PostData post = retrofit.create(PostData.class);
        UploadData uploadData = new UploadData(
                0, Instant.now().getEpochSecond(), 0.452, Arrays.asList(0.0, 24.0, 5.0), 34.542);
        Call<Empty> call = post.result(uploadData);
        Empty result = call.execute().body();
        System.out.println(gson.toJson(result));
    }
}
