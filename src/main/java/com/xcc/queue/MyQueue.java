package com.xcc.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/12/13
 * Time: 8:51 AM
 */
public class MyQueue<T>
{
    private LinkedList<T> queue;

    public MyQueue() {
        queue = new LinkedList<T>();
    }

    public int size() {
        return queue.size();
    }

    public void add(T t) {
        queue.addFirst(t);
    }

    public T remove() {
        if(queue.isEmpty())
            return null;
        return queue.removeLast();
    }
}
