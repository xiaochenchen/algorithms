package com.xcc;

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

        if(queue.size() == 1) {
            notifyAll();
        }

        queue.add(e);
        return true;
    }

    public synchronized T poll() {
        if(queue.size() == 0) {
            return null;
        }

        if(queue.size() == limit) {
            notifyAll();
        }

        return queue.remove(0);
    }

    public synchronized void put(T e) throws InterruptedException {
        while(queue.size() == limit) {
            wait();
        }
        if(queue.size() == 0) {
            notifyAll();
        }
        queue.add(e);
    }

    public synchronized T take() throws InterruptedException {
        while(queue.size() == 0) {
            wait();
        }
        if(queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }
}
