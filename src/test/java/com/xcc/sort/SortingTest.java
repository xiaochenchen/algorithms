package com.xcc.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 12:26 AM
 */
public class SortingTest
{
    @Test
    public void BubbleSortIntTest()
    {
        int[] arrayToSort = {6,5,3,1,8,7,2,4};
        System.out.println("Before Sort: " + Arrays.toString(arrayToSort));
        BubbleSort.sort(arrayToSort);
        System.out.println("After Sort: " + Arrays.toString(arrayToSort));
    }
}
