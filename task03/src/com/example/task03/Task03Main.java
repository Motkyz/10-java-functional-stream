package com.example.task03;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of("a","b","c"),
                String::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Iterator<? extends T> iter = stream.iterator();
        T currentElement = iter.hasNext() ? iter.next() : null;
        T min = currentElement;
        T max = currentElement;
        while (iter.hasNext()) {
            currentElement = iter.next();
            min = order.compare(min, currentElement) < 0 ? min : currentElement;
            max = order.compare(max, currentElement) > 0 ? max : currentElement;
        }
        minMaxConsumer.accept(min, max);
    }
}
