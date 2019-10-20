package com.example.datastruc_algo._04_lists;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ListsAlgo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ListsAlgo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int[] intArray = {20, 25, -15, 7, 55, 1, -22};

        Arrays.parallelSort(intArray);

        System.out.println("Lists_algo_sort -> " + Arrays.toString(intArray));
    }
}