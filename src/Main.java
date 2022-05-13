import com.sjsu.cmpe.sort.service.impl.QuickSortMultiThread;
import com.sjsu.cmpe.sort.service.impl.QuickSortSingleThread;

import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Comparable intArray[] = {1,4,6,25,74,7,4};
        Comparable intArrayCopy[] = intArray.clone();
        QuickSortSingleThread qs_singleThread = new QuickSortSingleThread(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort with one thread: " + qs_singleThread.getExecutionTime());

        QuickSortMultiThread qs_multiThread = new QuickSortMultiThread(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort with multi thread: " + qs_multiThread.getExecutionTime());


        intArray = getRandomIntArray(50000);
        intArrayCopy = intArray.clone();
        qs_singleThread = new QuickSortSingleThread(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort with one thread: " + qs_singleThread.getExecutionTime());

        qs_multiThread = new QuickSortMultiThread(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort with multi thread: " + qs_multiThread.getExecutionTime());

        String[] stringArray = getAlphaNumericString(5000);
        String[] stringArrayCopy = stringArray.clone();
        qs_singleThread = new QuickSortSingleThread(stringArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort with one thread: " + qs_singleThread.getExecutionTime());
        qs_multiThread = new QuickSortMultiThread(stringArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort with multi thread: " + qs_multiThread.getExecutionTime());
    }

    static Comparable[] getRandomIntArray(int length) {
        Comparable a[] = new Comparable[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) Math.floor(Math.random() * length * 5);
        }
        return a;
    }

    static String[] getAlphaNumericString(int length)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        String[] s = new String[length];
        StringBuilder sb;
        for(int i=0; i<length; i++){
            sb = new StringBuilder(5);
            for (int j = 0; j < 5; j++) {
                int index = (int)(AlphaNumericString.length()
                        * Math.random());
                sb.append(AlphaNumericString.charAt(index));
            }
            s[i] = sb.toString();
        }

        return s;
    }
}