package com.youknowwho.androidclient.train;

public class Configuration {
    public final String federated_optimizer;
    public final long comm_round;
    public final long epochs;
    public final long batch_size;
    public final String client_optimizer;
    public final double learning_rate;
    public final double weight_decay;

    public Configuration(String federated_optimizer, long comm_round, long epochs, long batch_size, String client_optimizer, double learning_rate, double weight_decay) {
        this.federated_optimizer = federated_optimizer;
        this.comm_round = comm_round;
        this.epochs = epochs;
        this.batch_size = batch_size;
        this.client_optimizer = client_optimizer;
        this.weight_decay = weight_decay;
        this.learning_rate = learning_rate;
    }
}
