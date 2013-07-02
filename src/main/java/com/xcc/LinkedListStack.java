package com.xcc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/1/13
 * Time: 9:59 PM
 */
public class LinkedListStack<T> {
    private List<T> stack;

    public LinkedListStack() {
        stack = new LinkedList<T>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T e) {
        stack.add(0, e);
    }

    public T pop() throws Exception {
        if(stack.isEmpty())
            throw new Exception("Emtpy Stack");
        return stack.remove(0);
    }
}
