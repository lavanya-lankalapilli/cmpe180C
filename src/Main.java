import com.sjsu.cmpe.sort.service.impl.QuickSortMultiThread;
import com.sjsu.cmpe.sort.service.impl.QuickSortSingleThread;
import com.sjsu.cmpe.sort.service.impl.MergeSortMultiThread;
import com.sjsu.cmpe.sort.service.impl.MergeSortSingleThread;

public class Main {
    public static void main(String[] args) {

        Comparable intArray[] = {1,4,6,25,74,7,4};
        Comparable intArrayCopy[] = intArray.clone();
        MergeSortSingleThread ms_singleThread = new MergeSortSingleThread(intArray);
        ms_singleThread.sort();
        System.out.println("Execution time for MergeSort for Integer array size:"+intArray.length+" with one thread: " + ms_singleThread.getExecutionTime());

        MergeSortMultiThread ms_multiThread = new MergeSortMultiThread(intArrayCopy);
        ms_multiThread.sort();
        System.out.println("Execution time for MergeSort for Integer array size:"+intArray.length+" with multi thread: " + ms_multiThread.getExecutionTime());

        intArray = new Comparable[]{1,4,6,25,74,7,4};
        intArrayCopy = intArray.clone();
        QuickSortSingleThread qs_singleThread = new QuickSortSingleThread(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort for Integer array size:"+intArray.length+" with one thread: " + qs_singleThread.getExecutionTime());

        QuickSortMultiThread qs_multiThread = new QuickSortMultiThread(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort for Integer array size:"+intArray.length+" with multi thread: " + qs_multiThread.getExecutionTime());


        intArray = getRandomIntArray(50000);
        intArrayCopy = intArray.clone();
        ms_singleThread = new MergeSortSingleThread(intArray);
        ms_singleThread.sort();
        System.out.println("Execution time for MergeSort for Integer array size:"+intArray.length+" with one thread: " + ms_singleThread.getExecutionTime());

        ms_multiThread = new MergeSortMultiThread(intArrayCopy);
        ms_multiThread.sort();
        System.out.println("Execution time for MergeSort for Integer array size:"+intArray.length+" with multi thread: " + ms_multiThread.getExecutionTime());

        intArray = getRandomIntArray(50000);
        intArrayCopy = intArray.clone();
        
        qs_singleThread = new QuickSortSingleThread(intArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort for Integer array size:"+intArray.length+" with one thread: " + qs_singleThread.getExecutionTime());

        qs_multiThread = new QuickSortMultiThread(intArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort for Integer array size:"+intArray.length+" with multi thread: " + qs_multiThread.getExecutionTime());

        String[] stringArray = getAlphaNumericString(5000);
        String[] stringArrayCopy = stringArray.clone();

        ms_singleThread = new MergeSortSingleThread(stringArray);
        ms_singleThread.sort();
        System.out.println("Execution time for MergeSort for String array size:"+stringArray.length+" with one thread: " + ms_singleThread.getExecutionTime());

        ms_multiThread = new MergeSortMultiThread(stringArrayCopy);
        ms_multiThread.sort();
        System.out.println("Execution time for MergeSort for String array size:"+stringArray.length+" with multi thread: " + ms_multiThread.getExecutionTime());

        stringArray = getAlphaNumericString(50000);
        stringArrayCopy = stringArray.clone();

        qs_singleThread = new QuickSortSingleThread(stringArray);
        qs_singleThread.sort();
        System.out.println("Execution time for QuickSort for String array size:"+stringArray.length+" with one thread: " + qs_singleThread.getExecutionTime());
        
        qs_multiThread = new QuickSortMultiThread(stringArrayCopy);
        qs_multiThread.sort();
        System.out.println("Execution time for QuickSort for String array size:"+stringArray.length+" with multi thread: " + qs_multiThread.getExecutionTime());
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