package sorting;

import java.util.EnumSet;

import static sorting.Algorithm.*;

public class Main {

    public static void main(String[] args) {
        int[] a = { 7, 1, 6, 2, 3, 8, 4, 5 };
        //int[] sizes = { 100, 1000, 10000, 100000 }; 
        //int[] sizes = {10, 20, 50, 100, 500, 1000, 2000, 5000, 10000};
        int[] sizes = {10};
        
        TestsOfSortingAlgorithms.traceOf(
                EnumSet.of(MERGE_SORT, HEAP_SORT), a);

        /*TestsOfSortingAlgorithms.performanceOf(
                EnumSet.allOf(Algorithm.class), sizes);*/
        TestsOfSortingAlgorithms.performanceOf(EnumSet.of(MERGE_SORT, HEAP_SORT), sizes);
    }
}