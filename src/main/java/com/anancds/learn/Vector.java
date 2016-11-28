package com.anancds.learn;

public class Vector {

    private int d;

    private double[] data;

    public Vector(int d) {
        this.d = d;
        data = new double[d];
    }

    public Vector(double... a) {
        d = a.length;

        // defensive copy so that client can't alter our copy of data[]
        data = new double[d];
        for (int i = 0; i < d; i++)
            data[i] = a[i];
    }

    public int dimension() {
        return d;
    }
}
