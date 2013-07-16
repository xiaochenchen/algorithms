package com.xcc.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 8:44 PM
 *
 * Selection Sort Properties
 * Not stable
 * O(1) extra space
 * O(n^2) comparison
 * O(n) swaps
 * Not adaptive
 */
public class SelectionSort
{
    public static void sort(int[] input)
    {
        int minIdx = 0;
        int temp = 0;
        for(int i = 0 ; i < input.length; ++i)
        {
            minIdx = i;
            for(int j = i + 1; j < input.length; ++j)
            {
                if(input[j] < input[minIdx])
                {
                    minIdx = j;
                }
            }
            if(minIdx != i)
            {
                temp = input[i];
                input[i] = input[minIdx];
                input[minIdx] = temp;

            }
        }

    }
}
