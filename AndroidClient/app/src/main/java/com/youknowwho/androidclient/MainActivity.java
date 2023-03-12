package com.youknowwho.androidclient;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.youknowwho.androidclient.train.Train;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    private final Train train = new Train();
    private TextView tv_main;
    private Button btn_get;
    private Button btn_post;

    @SuppressLint("CheckResult")
    public void getTask(View view) {
        Flowable.fromCallable(train::getTask)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> tv_main.setText(gson.toJson(result)),
                        error -> tv_main.setText(error.getMessage())
                );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main = findViewById(R.id.tv_main);
        btn_get = findViewById(R.id.btn_get);
        btn_post = findViewById(R.id.btn_post);

        btn_get.setOnClickListener(this::getTask);
    }
}
