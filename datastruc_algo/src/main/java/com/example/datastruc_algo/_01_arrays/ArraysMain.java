package com.example.datastruc_algo._01_arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArraysMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArraysMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        for(int i=0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }


	}
}
