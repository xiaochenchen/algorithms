package com.xcc.sort;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/14/13
 * Time: 11:44 PM
 *
 * Bubble Sort Properties
 * Stable
 * O(1) extra space
 * O(n^2) comparisons and swaps
 * Adaptive: O(n) when nearly sorted
 */
public class BubbleSort
{
    public static void sort(int[] input)
    {
        boolean swapped = false;
        int temp = 0;
        do {
            swapped = false;
            for(int i = 0; i < input.length - 1; ++i)
            {
                if(input[i] > input[i+1])
                {
                    temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
