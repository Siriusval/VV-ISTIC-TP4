package fr.istic.vv;
import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

    public static <T>  T[] bubblesort(T[] array, Comparator<T> comparator) {
        int  counter = 0;
        int n = array.length;
        //iterate n times
        for (int i = 0; i < n; i++) {

            //For each element and the next one
            for (int j = 0; j < n - 1; j++) {
                if (comparator.compare(array[j], array[j+1])<0) {
                    swap(array,j, j + 1);
                    counter++;
                }
            }
        }

        return array;
    }

    private static <T> void swap(T[] a,int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Swap adjacent elements if they are in decreasing order


    public static <T> T[] quicksort(T[] array, Comparator<T> comparator)  {
        return quicksortAlt(array, comparator, 0,array.length-1);
    }

    private static <T> T[] quicksortAlt(T[] array, Comparator<T> comparator, int startIndex, int endIndex)
    {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex)
        {
            // calculate the pivotIndex
            int pivotIndex = partition(array, comparator, startIndex, endIndex);
            // sort the left sub-array
            quicksortAlt(array, comparator, startIndex, pivotIndex);
            // sort the right sub-array
            quicksortAlt(array, comparator,pivotIndex + 1, endIndex);
        }

        return array;
    }

    private static <T> int partition(T[] array, Comparator<T> comparator, int startIndex, int endIndex)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true)
        {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (comparator.compare(array[startIndex],pivotValue) < 0) ;

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (comparator.compare(array[endIndex],pivotValue) < 0) ;

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }

    public static <T> T[] mergesort(T[] array, Comparator<T> comparator) {
        return mergesortAlt(array, comparator, array.length);
    }

    public static <T> T[] mergesortAlt(T[] array, Comparator <T> comparator, int n){
        if (!(n < 2)) {
            int split = n / 2;
            T[] left = Arrays.copyOf(array, split);
            T[] right = Arrays.copyOfRange(array, split, n);

            mergesortAlt(left, comparator, split);
            mergesortAlt(right, comparator, n - split);

            merge(array, comparator, left, right, split, n - split);
        }
        return array;
    }

    public static <T> void merge(T[] array, Comparator<T> comparator, T[] left, T[] right, int leftIndex, int rightIndex){
        int a = 0 ,b = 0,c = 0;
        while(a < leftIndex && b <rightIndex){
            if(comparator.compare(array[a],array[b])<0){
                array[c++] = array[a++];
            }
            else{
                array[c++] = array[b++];
            }

            while(a < leftIndex){
                array[c++] = array[a++];
            }

            while(b < rightIndex){
                array[c++] = array[b++];
            }
        }
    }

}
