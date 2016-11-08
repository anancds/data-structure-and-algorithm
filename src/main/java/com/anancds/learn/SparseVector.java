package com.anancds.learn;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {

    //dimension
    private int d;

    //the vector, represented by index-value pairs
    private Map<Integer, Double> map;

    public SparseVector(int d) {
        this.d = d;
        this.map = new HashMap<>();
    }

    public void put(int i, double value) {
        if (i < 0 || i >= d) throw new IndexOutOfBoundsException("Illegal index");
        if (value == 0.0) {
            map.remove(i);
        } else {
            map.put(i, value);
        }

    }

    public double get(int i) {
        if (i < 0 || i >= d) throw new IndexOutOfBoundsException("Illegal index");
        if (map.containsKey(i)) return map.get(i);
        else return 0.0;
    }

    /**
     * Returns the number of nonzero entries in this vector.
     *
     * @return the number of nonzero entries in this vector
     */
    public int nnz() {
        return map.size();
    }

    public int dimension() {
        return d;
    }

    public double dot(SparseVector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Vector lengths disagree");
        double sum = 0.0;

        if (this.map.size() <= that.map.size()) {
            for (int i : this.map.keySet()) {
                if (that.map.containsKey(i))
                    sum += this.get(i) * that.get(i);
            }
        } else {
            for (int i : that.map.keySet()) {
                if (this.map.containsKey(i))
                    sum += this.map.get(i) * that.map.get(i);
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "SparseVector{" +
                "d=" + d +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        SparseVector vector = new SparseVector(4);
        vector.put(0, 0.0);
    }
}
