package com.xcc.sort;

import com.xcc.heap.MyMinHeap;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 8:58 PM
 */
public class HeapSort
{
    public static void sortWithHeap(int[] input)
    {
        MyMinHeap heap = new MyMinHeap(input.length);
        for(int i = 0; i < input.length; ++i)
        {
            heap.add(input[i]);
        }
        for(int i = 0; i < input.length; ++i)
        {
            input[i] = heap.delete();
        }
    }
}
