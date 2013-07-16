package com.xcc.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/15/13
 * Time: 9:06 PM
 *
 * Implement with array
 * index of children for node n: 2n+1 and 2n+2
 * index of parent for node n: (n-1)/2
 */
public class MyMinHeap
{
    private int[] heap;
    private int curIdx = -1;

    private MyMinHeap()
    {}

    public MyMinHeap(int size)
    {
        heap = new int[size];
    }

    public int size()
    {
        return curIdx + 1;
    }

    public void add(int e)
    {
        // double heap size if reached limit
        if(curIdx == heap.length - 1)
        {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        heap[++curIdx] = e;
        siftUp();
    }

    public int delete()
    {
        if(curIdx == -1)
        {
            throw new NoSuchElementException("Heap is empty");
        }

        int result = heap[0];
        heap[0] = heap[curIdx--];
        siftDown();
        return result;
    }

    /**
     * O(log_2(n))
     */
    public void siftUp()
    {
        int c = curIdx;
        int p, temp;
        while( c > 0)
        {
            p = (c - 1)/2;
            if(heap[c] < heap[p])
            {
                temp = heap[c];
                heap[c] = heap[p];
                heap[p] = temp;
                c = p;
            } else {
                break;
            }
        }
    }

    /**
     * O(log_2(n))
     */
    public void siftDown()
    {
        int i = 0;
        int l = 1, r = 2, min, temp;
        while(l <= curIdx)
        {
            if(r > curIdx || heap[l] < heap[r])
                min = l;
            else
                min = r;

            if(heap[i] > heap[min])
            {
                temp = heap[i];
                heap[i] = heap[min];
                heap[min] = temp;
                i = min;
                l = 2*i+1;
                r = 2*i+2;
            }
            else
                break;
        }

    }
}
