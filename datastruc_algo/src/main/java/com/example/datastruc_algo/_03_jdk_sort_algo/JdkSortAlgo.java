package com.example.datastruc_algo._03_jdk_sort_algo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JdkSortAlgo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdkSortAlgo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int[] intArray = {20, 25, -15, 7, 55, 1, -22};

        Arrays.parallelSort(intArray);

        System.out.println("JDK_sort -> " + Arrays.toString(intArray));
    }
}