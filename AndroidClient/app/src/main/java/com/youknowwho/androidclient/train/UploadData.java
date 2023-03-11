package com.youknowwho.androidclient.train;

import java.util.List;

public class UploadData {
    public final int device_id;
    public final double send_time;
    public final double local_loss;
    public final List<Double> local_weights;
    public final double training_duration;

    public UploadData(int device_id, double send_time, double local_loss, List<Double> local_weights, double training_duration) {
        this.device_id = device_id;
        this.send_time = send_time;
        this.local_loss = local_loss;
        this.local_weights = local_weights;
        this.training_duration = training_duration;
    }
}
