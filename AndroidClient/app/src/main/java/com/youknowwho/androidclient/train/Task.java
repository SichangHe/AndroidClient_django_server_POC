package com.youknowwho.androidclient.train;

import java.util.List;

public class Task {
    public final Configuration configuration;
    public final double send_time;
    public final List<Double> global_weights;

    public Task(Configuration configuration, double send_time, List<Double> global_weights) {
        this.configuration = configuration;
        this.send_time = send_time;
        this.global_weights = global_weights;
    }
}
