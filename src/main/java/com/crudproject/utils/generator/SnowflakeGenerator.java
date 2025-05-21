package com.crudproject.utils.generator;

public class SnowflakeGenerator {

    private static final SnowflakeWorker worker = new SnowflakeWorker(1, 1);

    public static long generate() {
        return worker.nextId();
    }

}
