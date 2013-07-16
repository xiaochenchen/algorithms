package com.xcc.sort;

import com.xcc.heap.MyMinHeap;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 8:58 PM
 *
 * Heapsort Properties:
 * Not Stable
 * O(1) extra space
 * O(nlog_2(n)) time
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

    public static void sortLoop(int[] input)
    {
        heapifyLoop(input);
        int temp;
        for(int i = input.length - 1; i >= 0; --i)
        {
            temp = input[0];
            input[0] = input[i];
            input[i] = temp;
            siftDownLoop(input, 0, i);
        }
    }

    private static void heapifyLoop(int[] input)
    {
        for(int i = (input.length - 2) / 2; i >=0; --i)
        {
            siftDownLoop(input, i, input.length);
        }
    }

    private static void siftDownLoop(int[] input, int i, int n)
    {
        // l = left child index, r = right child index
        // max = index of current max among parent,left child and right child
        int l = 2 * i + 1;
        int r, max, temp;
        while(l < n)
        {
            r = l + 1;
            max = (r < n) ? ( (input[l] > input[r]) ? l : r ) : l;
            if(input[i] < input[max])
            {
                temp = input[i];
                input[i] = input[max];
                input[max] = temp;
                i = max;
                l = 2 * i + 1;
            }
            else
                break;
        }
    }
}
