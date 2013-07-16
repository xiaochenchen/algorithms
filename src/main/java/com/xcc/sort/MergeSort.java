package com.xcc.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/16/13
 * Time: 6:50 AM
 *
 * Merge Sort Properties
 * Divide and Conquer
 */
public class MergeSort
{
    public static void sort(int[] input)
    {
        mergeSort(input, 0, input.length - 1);
    }

    /**
     *
     * @param input
     * @param start - inclusive
     * @param end - inclusive
     */
    private static void mergeSort(int[] input, int start, int end)
    {
        // recursion base case
        if(start == end)
        {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid + 1, end);
        merge(input, start, mid, end);
    }

    /**
     *
     * @param input
     * @param start - inclusive
     * @param mid - inclusive to the left half
     * @param end - inclusive
     */
    private static void merge(int[] input, int start, int mid, int end)
    {
        // make a copy of left half
        int[] copyOfLeft = Arrays.copyOfRange(input, start, mid + 1);

        int tc = start, lc =  0, rc = mid + 1;
        // merge until one half is exhausted
        while( lc < copyOfLeft.length && rc < end + 1 )
        {
            input[tc++] = (copyOfLeft[lc] < input[rc]) ? copyOfLeft[lc++] : input[rc++];
        }

        // if left side exhausted, we are done
        // if right side exhausted, copy the rest of left side
        while( lc < copyOfLeft.length )
        {
            input[tc++] = copyOfLeft[lc++];
        }
    }
}
