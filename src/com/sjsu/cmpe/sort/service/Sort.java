package com.sjsu.cmpe.sort.service;

public interface Sort {
    int thresholdSize = 100;
    void sort();
    long getExecutionTime();
}