package com.anancds.learn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 用链表实现一个multiSet
 *
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

    //指向第一个元素
    private Node<Item> first;

    //元素个数
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("a");
        bag.add("b");
        bag.add("c");

        for (String s : bag) {
            System.out.println(s);
        }
    }
}
