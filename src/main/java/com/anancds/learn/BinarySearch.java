package com.anancds.learn;

/**
 * Created by cds on 1/20/17 21:26.
 */
public class BinarySearch {

    private BinarySearch() {

    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) >>> 1;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }
}
