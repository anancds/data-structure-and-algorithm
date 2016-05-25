package com.anancds.learn;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TheArrayList<T> implements Iterable<T>{

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;

    //是否用object更好
    private T[] theItems;

    public TheArrayList() {

    }

    public void clear() {

    }

    private void doClear() {
        theSize = 0;

    }


    public Iterator<T> iterator() {
        return null;
    }

    public void forEach(Consumer<? super T> action) {

    }

    public Spliterator<T> spliterator() {
        return null;
    }
}
