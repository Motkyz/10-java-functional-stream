package com.example.task04;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = br.lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^а-яёa-z]")))
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());

        Map<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i))) {
                map.replace(list.get(i), map.get(list.get(i)) + 1);
            }
            else {
                map.put(list.get(i), 1);
            }
        }

        map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(e -> System.out.print(e.getKey() + "\n"));
    }
}
