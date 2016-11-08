package com.anancds.learn;

import java.util.Arrays;
import java.util.Stack;

/**
 * The Project name is data-structure
 * Created by cds on 15/5/16.
 */
//缺查询接口
public class TheStack<E> {

    private Object[] objects;

    private int statkSize;

    private int topOfStack = -1;

    TheStack(int size) {

        objects = new Object[size];

        statkSize = size;

    }

    public synchronized E push(E element) {

        if (topOfStack + 1 < statkSize) {

            topOfStack++;

            objects[topOfStack] = element;

        } else
            throw new IndexOutOfBoundsException("the stack is out of index!");

        return element;
    }

    public synchronized E pop() {
        E object;
        //peek已经有了index的判断,所以这里就没有继续去判断.
        object = peek();
        objects[topOfStack--] = null;
        return object;
    }

    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        if (topOfStack >= 0) {
            return (E) objects[topOfStack];
        } else
            throw new IndexOutOfBoundsException();
    }

    public synchronized boolean isEmpty() {
        return topOfStack < 0;
    }


    @Override
    public String toString() {
        return "TheStack{" +
                "objects=" + Arrays.toString(objects) +
                ", statkSize=" + statkSize +
                ", topOfStack=" + topOfStack +
                '}';
    }

    public static void main(String[] args) {

        Stack<String> strings = new Stack<>();
        for (int i = 0; i < 11; ++i) {
            strings.push("a");
        }
        strings.push("b");
        System.out.println(strings.search("a"));
        //缺查询接口
    }
}
