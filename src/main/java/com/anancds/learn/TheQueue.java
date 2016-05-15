/**
 * The Project name is data-structure
 * Created by cds on 15/5/16.
 */
package com.anancds.learn;

public class TheQueue<E> {
    private Object[] queueObject;

    private int queueSize;

    private int front, rear, numberOfItems = 0;

    TheQueue(int size) {
        queueSize = size;
        queueObject = new Object[size];

    }

    public synchronized void insert(E element) {
        if (numberOfItems + 1 <= queueSize) {
            queueObject[rear] = element;
            rear++;
            numberOfItems++;
        } else
            throw new IndexOutOfBoundsException();
    }

    public synchronized void remove() {
        if (numberOfItems > 0) {
            queueObject[front] = null;
            front++;
            numberOfItems--;
        } else
            throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        if (numberOfItems > 0) {
            return (E)queueObject[front];
        } else
            throw new IndexOutOfBoundsException();
    }



    public synchronized boolean isEmpty() {
        return numberOfItems == 0;
    }
}
