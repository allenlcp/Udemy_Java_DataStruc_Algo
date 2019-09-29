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
//        runBubbleSort();
//        runSelectionSort();
//        runInsertionSort();
//        runShellSort();
        runMergeSort();

        // Factorial
        // 1! = 1 * 0! = 1
        // 2! = 2 * 1 = 2 * 1!
        // 3! = 3 * 2 * 1 = 3 * 2!
        // 4! = 4 * 3 * 2 * 1 = 4 * 3!
        // n! = n * (n-1)!
//        System.out.println(runInterativeFactorial(3));

        // Recursive call in order but return in reverse
//        System.out.println(runRecursiveFactorial(3));
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

    private void runSelectionSort() {
        int[] intArray = {20 ,35, -15, 7, 55, 1, -22};

        for(int lastUnsortedIndex=intArray.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            int largest = 0;

            for(int i=1; i <= lastUnsortedIndex;i++){
                if(intArray[i] > intArray[largest]){
                    largest = i;
                }
            }

            swap(intArray, largest, lastUnsortedIndex);
        }

        System.out.println("BubbleSort -> " + Arrays.toString(intArray));
    }

    private void runInsertionSort() {
        int[] intArray = {20 ,35, -15, 7, 55, 1, -22};

        for(int firstUnsorted=1; firstUnsorted < intArray.length; firstUnsorted++){
            int newElement = intArray[firstUnsorted];

            int i;

            for(i=firstUnsorted; i > 0 && intArray[i-1] > newElement; i--){
                intArray[i] = intArray[i-1];
            }

            intArray[i] = newElement;

        }

        System.out.println("InsertionSort -> " + Arrays.toString(intArray));

    }

    private void runShellSort() {
        int[] intArray = {20 ,35, -15, 7, 55, 1, -22};

        for(int gap = intArray.length/2; gap > 0; gap /=2){
            for(int i=gap; i < intArray.length; i++){
                int newElement = intArray[i];
                int j = i;

                while(j>=gap && intArray[j-gap] > newElement){
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
        }

        System.out.println("ShellSort -> " + Arrays.toString(intArray));
    }


    private void runMergeSort() {
        int[] intArray = {20 ,35, -15, 7, 55, 1, -22};

        runMergeSort_MergeSort(intArray, 0, intArray.length);

        System.out.println("MergeSort -> " + Arrays.toString(intArray));
    }

    private void runMergeSort_MergeSort(int[] input, int start, int end){
        System.out.println("Entering MergeSort -> Array: " + Arrays.toString(input) + " -> Start: " + start + " -> End: " + end + " -> subarray left: " + Arrays.toString(Arrays.copyOfRange(input, start, end)));

	    // break condition - when we have a one element sorted array
	    if(end - start < 2){
            System.out.println("Returning MergerSort -> Breaking and returning");
	        return;
        }

	    int mid = (start + end) / 2;

	    // left partition splitting
	    runMergeSort_MergeSort(input, start, mid);

	    // right partition splitting
        runMergeSort_MergeSort(input, mid, end);

        // merge
        runMergeSort_Merge(input, start, mid, end);
    }

    private void runMergeSort_Merge(int[] input, int start, int mid, int end){

        System.out.println("Entering Merge -> Array: " + Arrays.toString(input) + " -> Start: " + start + " -> Mid: " + mid + " -> End: " + end + " -> left_subarray: " + Arrays.toString(Arrays.copyOfRange(input, start, mid))+ " -> right_subarray: " + Arrays.toString(Arrays.copyOfRange(input, mid, end)));

	    // first optimisation
        // Example: {-5, -15, 35, 1, 7}
        // After split and merge until -> Left: {-15, -5}  Right: {1, 7, 35}
        // Since both left and right are sorted
        // If mid (start of right hand side) is greater or equal to last element (mid - 1) on the left hand side.  We don't need to copy to the temporary array and re-copy to original array.
	    if(input[mid - 1] <= input[mid]){
	        return;
        }

        int i = start;
	    int j = mid;
	    int tempIndex = 0;

	    int[] temp = new int[end - start];

	    while (i < mid && j < end){
            System.out.println("Before sorting -> input[" + i + "]: " + input[i] + " -> input[" + j + "]: " + input[j]);
	        temp[tempIndex++] = (input[i] <= input[j]) ? input[i++] : input[j++];
            System.out.println("Filling temp arrays-> " + Arrays.toString(temp));
        }

	    // second optimisation

        // If we have things remaining on the right handside - NO FURTHER processing is required
        // {32, 34},{33, 36}
        // {32, 33, 34} -> drop out of loop because we finish processing the left hand side
        // if we copy 36 to temp array i.e {32, 33, 34, 36}, we will then be re-copying 36 to its original position in the original array
        // therefore we don't need to copy the right hand side as they are already sorted by default

        // However, if we have things remaining on the left hand side - We need to copy them accordingly
        // {32, 36},{33, 34}
        // {32, 33, 34, 36} -> The element/index 1 of the array will need to be copied to index 3

        System.arraycopy(input, i, input, start + tempIndex, mid - i);  // only applicable if there are things remaining in the left array
        if(mid-i > 0 ) {
            System.out.println("Merge - after copying the remaining left hand side to position in original array " + Arrays.toString(input));
        }
        System.arraycopy(temp, 0 , input, start, tempIndex); // copy temp to original array
        System.out.println("Merge - after copying sorted temp array to original array " + Arrays.toString(input) + " -> start: " + start + " -> tempIndex: " + tempIndex);

    }

    private int runInterativeFactorial(int num){
	    if(num == 0){
	        return 1;
        }

	    int factorial = 1;
	    for(int i=1; i<= num; i++){
	        factorial *= i;
        }

	    return factorial;
    }

    private int runRecursiveFactorial(int num){
        if(num == 0){ // known as the break case or default condition (required in recursion, otherwise we will get a stackoverflow error)
            return 1;
        }
        return num * runRecursiveFactorial(num - 1);
    }

    // Swap method
    private void swap(int[] array, int i, int j){
	    if (i == j){ return; } // If same, no need to swap - make sort stables

	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
    }
}
