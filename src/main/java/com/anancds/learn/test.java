package com.anancds.learn;

/**
 * Created by cds on 11/6/16 12:09 AM.
 */
public class test {
    public static void main(String[] args) {
        In in = new In("src/main/resources/file.txt");
        TheStack<String> stack = new TheStack<>(10);

        while (!in.isEmpty()) {
            stack.push(in.readString());
        }

        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
