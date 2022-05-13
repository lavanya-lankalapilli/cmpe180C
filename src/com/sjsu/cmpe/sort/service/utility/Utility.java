package com.sjsu.cmpe.sort.service.utility;

public class Utility {

    public int partition(Comparable array[], int low, int high) {
        Comparable pivot = array[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    public void swap(Comparable array[], int p, int r) {
        Comparable t = array[p];
        array[p] = array[r];
        array[r] = t;
    }

    public void selectionSort(Comparable arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;
            Comparable temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

}