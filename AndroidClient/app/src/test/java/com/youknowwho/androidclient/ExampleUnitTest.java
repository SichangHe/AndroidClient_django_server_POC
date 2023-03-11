package com.youknowwho.androidclient;

import static com.youknowwho.androidclient.GreetKotlinKt.greetKotlin;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void greetKotlin_works() {
        greetKotlin();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
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
        System.out.println(user);
    }
}
