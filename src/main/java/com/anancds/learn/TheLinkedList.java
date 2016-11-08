package com.anancds.learn;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class TheLinkedList<E> implements Iterable<E> {

    private int theSize;

    private int modCount = 0;

    private Node<E> first;

    private Node<E> last;

    public TheLinkedList() {

    }


    private static class Node<T> {
        public Node(T d, Node<T> prev, Node<T> next) {
            data = d;
            this.prev = prev;
            this.next = next;
        }

        T data;
        Node<T> prev;
        Node<T> next;
    }

    private void doClear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        theSize = 0;
        modCount++;
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }


    public Iterator<E> iterator() {
        return null;
    }

    public void forEach(Consumer<? super E> action) {

    }

    public Spliterator<E> spliterator() {
        return null;
    }
}
