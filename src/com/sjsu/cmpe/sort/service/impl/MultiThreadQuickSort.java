package com.sjsu.cmpe.sort.service.impl;
import com.sjsu.cmpe.sort.service.Sort;
import com.sjsu.cmpe.sort.service.utility.Utility;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MultiThreadQuickSort implements Sort {

    Comparable array[];
    long executionTime = 0;
    ForkJoinPool forkJoinPool;
    Utility utility;

    public MultiThreadQuickSort(Comparable array[]) {
        this.array = array;
        forkJoinPool = new ForkJoinPool();
        utility = new Utility();
    }

    @Override
    public void sort() {
        long startTime = System.currentTimeMillis();
        if(array.length<100){
            utility.selectionSort(array);
            return;
        } else {
            int pivot = utility.partition(array, 0, array.length - 1);
            QuickSortTask leftTask = new QuickSortTask(array, 0, pivot - 1);
            QuickSortTask rightTask = new QuickSortTask(array, pivot + 1, array.length - 1);
            leftTask.fork();
            rightTask.fork();
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    class QuickSortTask extends RecursiveAction {

        int left;
        int right;
        Comparable[] array;

        QuickSortTask(Comparable[] arr, int left, int right) {
            this.left = left;
            this.right = right;
            array = arr;
        }

        protected void compute() {
            sort(left, right);
        }

        private void sort(int left, int right) {
            if (left < right) {
                int pivot = utility.partition(array, left, right);
                sort(left, pivot - 1);
                sort(pivot + 1, right);
            }
        }

    }
}