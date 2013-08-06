package com.xcc.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/1/13
 * Time: 11:26 PM
 */
public class MyBlockingQueue<T> {
    private List<T> queue;
    private int limit;

    public MyBlockingQueue() {
        queue = new LinkedList<T>();
        limit = 10;
    }

    public MyBlockingQueue(int limit) {
        queue = new LinkedList<T>();
        this.limit = limit;
    }

    public synchronized int size() {
        return queue.size();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }

    public synchronized boolean offer(T e) {
        if(queue.size() == limit) {
            return false;
        }

        queue.add(e);

        if(queue.size() == 1) {
            notifyAll();
        }
        
        return true;
    }

    public synchronized T poll() {
        if(queue.size() == 0) {
            return null;
        }

        T ret = queue.remove(0);

        if(queue.size() == limit - 1) {
            notifyAll();
        }

        return ret;
    }

    public synchronized void put(T e) throws InterruptedException {
        while(queue.size() == limit) {
            wait();
        }
        
        queue.add(e);
        
        if(queue.size() == 1) {
            notifyAll();
        }        
    }

    public synchronized T take() throws InterruptedException {
        while(queue.size() == 0) {
            wait();
        }
        
        T ret = queue.remove(0);
        
        if(queue.size() == limit - 1) {
            notifyAll();
        }
        
        return ret;
    }
}
