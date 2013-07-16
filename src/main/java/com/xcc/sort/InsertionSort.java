package com.xcc.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 8:10 PM
 *
 * Insertion Sort Properties
 * Stable
 * O(1) extra space
 * O(n^2) comparisons and swaps
 * Adaptive O(n) time when nearly sorted
 */
public class InsertionSort
{
    public static void sort(int[] input)
    {
        int temp = 0;
        for(int i = 1; i < input.length; ++i)
        {
            for(int j = i; j >0 ; --j)
            {
                if(input[j] < input[j-1])
                {
                    temp = input[j];
                    input[j] =input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }
}
