package com.example.datastruc_algo._02_sort_algo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SortAlgoMain implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SortAlgoMain.class, args);
	}

	//**************************************************************
    // Only showing one implementation (there are other types)
    //**************************************************************

	@Override
	public void run(String... args) throws Exception {
        runBubbleSort();

	}

    private void runBubbleSort() {
        int[] intArray = {20 ,35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex=intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            for(int i=0; i < lastUnsortedIndex;i++){
                if(intArray[i] > intArray[i+1]){
                    swap(intArray, i, i+1);
                }
            }
        }

        System.out.println("BubbleSort -> " + Arrays.toString(intArray));
    }

    // Swap method
    private void swap(int[] array, int i, int j){
	    if (i == j){ return; } // If same, no need to swap - make sort stables

	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
    }
}
