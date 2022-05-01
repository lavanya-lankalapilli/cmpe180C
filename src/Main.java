import com.sjsu.cmpe.sort.service.impl.MultiThreadQuickSort;
import com.sjsu.cmpe.sort.service.impl.QuickSort;

public class Main {
    public static void main(String[] args) {

        Comparable intArray[] = {1,4,6,25,74,7,4};
        Comparable intArrayCopy[] = intArray.clone();
        QuickSort qs_singleThread = new QuickSort(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort with one thread: " + qs_singleThread.getExecutionTime());

        MultiThreadQuickSort qs_multiThread = new MultiThreadQuickSort(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time fpr QuickSort with multi thread: " + qs_multiThread.getExecutionTime());


        intArray = getRandomIntArray(50000);
        intArrayCopy = intArray.clone();
        qs_singleThread = new QuickSort(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort with one thread: " + qs_singleThread.getExecutionTime());

        qs_multiThread = new MultiThreadQuickSort(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time fpr QuickSort with multi thread: " + qs_multiThread.getExecutionTime());

    }

    static Comparable[] getRandomIntArray(int length) {
        Comparable a[] = new Comparable[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) Math.floor(Math.random() * length * 5);
        }
        return a;
    }
}