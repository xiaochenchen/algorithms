package com.xcc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 7/1/13
 * Time: 9:35 PM
 */
public class ArrayListStack<T> {
    private List<T> stack;

    public ArrayListStack()
    {
        stack = new ArrayList<T>();
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public int size()
    {
        return stack.size();
    }

    public void push(T e) {
        stack.add(e);
    }

    public T pop() throws Exception {
        if(stack.isEmpty())
        {
            throw new Exception("Stack empty");
        }
        return stack.remove(stack.size() - 1);
    }
}
