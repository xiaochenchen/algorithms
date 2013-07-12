package com.xcc.heap;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/12/13
 * Time: 9:04 AM
 */
public interface MyHeap<T>
{
    public void siftUp();
    public void siftDown();
    public void add();
    public void delete();
}
