package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) {
            throw new IllegalArgumentException();
        }

        return IntStream.iterate(0, i -> i + 1).map(i -> GetGrayCode(i % (int) Math.pow(2, n)));
    }

    static int GetGrayCode(int g) {
        return g ^ (g >> 1);
    }
}
