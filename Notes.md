### Performance calculation
* Time complexity
* Memory complexity

Use worse case better than taking average

### Time complexity - allows us to benchmark independent of hardware
* Number of desired sugars = n
* Total number of steps = 2n + 2
* As n grows, the number of steps grows
* The "2" in the 2n and the "+2" remain constant, so they don't factor into the time complexity. The value of n determines the growth rate.
* Time complexity is O(n) (big "O" notation)
* Linear time complexity 

* One tip to determine time complexity is to look at how many loops there are. Each loop correspond to n.  
  * One loop is linear
  * Two loops is nxn -> quadratic

### Big-O
<table>
    <tr>
        <td colspan="2">Big-O</td>
    </tr>
    <tr>
        <td>O(1)</td>
        <td>Constant</td>
    </tr>
    <tr>
        <td>O(logn)</td>
        <td>Logarithmic</td>
    </tr>
    <tr>
        <td>O(n)</td>
        <td>Linear</td>
    </tr>
    <tr>
        <td>O(nlogn)</td>
        <td>n log-star n</td>
    </tr>
    <tr>
        <td>O(n^2)</td>
        <td>Quadratic</td>
    </tr>
</table>

___

# Arrays

## Arrays in Memory
* None dynamic data structure 
* Fix in size - done at initialization
* Indices are zero based

* Contiguous block in memory (not scattered around)
  * e.g arrays start at memory address 200 - then the next "x" amount of bytes are the array size
* Every element occupies the same amount of space in memory
  * For primitives - it's obvious (they will be of same size)
  * What about objects like String and etc - will it grow in size as the object grows - **NO**, because java stores the **object reference** (which are always the same size regardless of the type of object being reference)
* If an array starts at memory address x, and the size of each element in the array is y, we can calculate the memory address of the ith element by using the following expression: x + i * y
* If we know the index of an element, the time to retrieve the element will be the same, no matter where it is in the array
 
<table>
    <tr>
        <td>
            <img width="350" alt="arrays" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_001.png">
        </td>
    </tr>
</table>


* Memory start address of 12 is for illustration purposes only
* For the first element in the array we actually do the same calculation [12 + (0 * 4) = 12].  Actually we use the same formula everywhere.  Therefore, this may explain why array indices are **zero** based.  If the weren't we would have to subtract one in the formula.
* int is of size = 4 bytes
* Arrays really good a retrieving element if we know the index
___

## Arrays and Big-O notation
### Retrieve an Element from an Array
1. Multiply the size of the element by its index
2. Get the start address of the array
3. Add the start address to the result of the multiplication

### Retrieve an Element from an Array - when we know the index
* Therefore it doesn't matter how big is the array, we **only** have these 3 steps to find the element.  The steps to retrieve never changes. We therefore have **constant time complexity O(1)** - means as the number of item increases, the algorithm does not degrade.

### Retrieve an Element from an Array - when we do NOT know the index
* We will need to loop through the array to find element but we need to consider the worse case scenario for big-o, therefore we will assume that we will have to loop through the entire array.  As such the big-o notation is **O(n)**.

<p align="center">
    <img width="700" alt="array big-o" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_002.png">
</p>

* **Add an element to a full array** - we will have to create a new array and loop through existing array from start to finish and copy to the new array before adding the new element.

___

# Sort Algorithms

### Stable vs Unstable sort algo
Comes into play when there are duplicate values in the data to be sorted.
Question - will the original ordering be preserved after sorting. i.e will the white 9 come before the black 9

* **unstable sort** - original ordering will **not** be preserved
* **stable sort** - original ordering will be preserved (all this equal, this one is preferred)

<table>
    <tr>
        <td>
            <img width="300" alt="unstable sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_004.png">
        </td>
        <td>
            vs
        </td>
        <td>
            <img width="300" alt="stable sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_005.png">
        </td>
    </tr>
</table>


### 1. Bubble sort (because the larger/smaller/etc number will bubble to the top - depending on implementation)
* **In-place algorithm** - logically partitioning array, no need to create new array for sorting.  However in the implementation we create a few local variables.  It is an in place algo if the extra memory that you need does not depend on the item you are sorting. i.e additional memory for processing will not increase with an the size of the array
* O(n^2) time complexity - **quadratic**, meaning itt will take:
  * 100 step to sort 10 items, 
  * 10,000 steps to sort 100 items, 
  * 1,000,000 steps to sort 1000 items
  * but it's **not exactly true** as the sorted partition is growing there is less sorting to do (for the inner loop). However, we are not looking for exact number, we trying a general sense (approximation) on how the number of step grows as the item grows.  

* Algo degrades quickly
* Least efficient sorting algo
* Is a stable sort - we only swap if the elements a different


<table>
    <tr>
        <td>
            <img width="400" alt="bubble sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_003.png">
        </td>
    </tr>
</table>


* Performance degrades as n increases
* We do multiple traversal for the sort
  * we find the biggest number first and put it at index 6 and it's part of the sortedPartition 
  * we then re-start over again to sort for the unsortedPartition (i.e index 0 to 5) which will result having the second largest number set at index 6
  * etc... etc...


### 2. Selection sort 
* It's is called the selection sort because on each traversal, we are selecting the largest element and we are moving it to the sorted partition

* In-place algorithm
* O(n^2) time complexity - quadratic
* It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items, 1,000,000 steps to sort 1000 items
* Doesn't require as much swapping as bubble sort (therefore perform better)

<table>
    <tr>
        <td>
            <img width="400" alt="select sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_006.png">
        </td>
    </tr>
</table>

<table>
    <tr>
        <td>
            <img width="400" alt="select sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_007.png">
        </td>
    </tr>
</table>


### 3. Insertion sort (traverse from left to right for unsorted but compare right to left for sorted partition)

* In-place algorithm
* O(n^2) time complexity - quadratic
* It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items, 1,000,000 steps to sort 1000 items
* Stable algorithm


### 4. Shell sort

* Variation of insertion sort
* Insertion sort chooses which element to insert using a gap of 1
* Shell sort starts out using a larger gap value
* As the algorithm runs, the gaps is reduced
* Goal is to reduce the amount of shifting required

* As the algo progresses, the gap is reduced
* The last gap value is always 1
* A gap value of 1 is equivalent to insertion sort
* So, the algo does some preliminary work (using gap values greater than 1), and then becomes insertion sort
* By the time we get to insertion sort, the array has partially sorted, so there's less shifting required

* Calculation/selection of the gap value can influence the time complexity - see wiki for some examples

* Common sequence used for gap/interval value is the "Knuth sequence"

<table>
    <tr>
        <td>
            <img width="400" alt="shell sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_008.png">
        </td>
    </tr>
</table>

* Gap is calculated using (3^k - 1)/2
* We set "k" based on the length of the array
* We want the gap to be as close as possible to the length of the array we want to sort, without being greated than the length

Simplified implementation example:
<table>
    <tr>
        <td>
            <img width="400" alt="shell sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_009.png">
        </td>
    </tr>
</table> 
<table>
    <tr>
        <td>
            <img width="400" alt="shell sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_010.png">
        </td>
    </tr>
</table> 
<table>
    <tr>
        <td>
            <img width="400" alt="shell sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_011.png">
        </td>
    </tr>
</table> 
<table>
    <tr>
        <td>
            <img width="400" alt="shell sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_012.png">
        </td>
    </tr>
</table> 

and etc....

* In-place algorithm
* Difficult to nail down the time complexity because it will depend on the gap. Worse case: O(n^2), but it can perform much better than that
* Doesn't require as much shifting as insertion sort, so it usually performs better
* Unstable algorithm




### Small timeout for reviewing Recursion (eg factorial)

* Recursive call is in sequential order but return in reverse
* Need a break case or default condition, otherwise we will get a stack overflow error
* But event with default condition, the recursion can still blowup the stack if it calls itself too often (solution in other languages is tail recursion - not applicable in java)
* The iterative implementation runs faster and it does not need a lot of memory
* Recursion needs more memory in the call stack





### 5.1 Merge sort - overall
* Divide and conquer algorithm
* Recursive algo
* Two phases: Splitting and Merging
* Splitting phase leads to faster sorting during the Merging phase
* Splitting is logical.  We don't create new arrays


### 5.2 Merge sort - splitting phase
* Start with an unsorted array
* Divide the array into two arrays (depending on implementation, for odd arrays, one will have one more element than the other), which are unsorted.  The first array is left array, and the second array is the right array
* Split the left and right arrays into two arrays each
* Keep splitting until all the arrays have only one element each - these arrays are sorted

<table>
    <tr>
        <td>
            <img width="400" alt="merge sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_013.png">
        </td>
    </tr>
</table> 

### 5.3 Merge sort - merging phase
* Merge every left/right pair of sibling arrays into a sorted array
* After the first merge, we'll have a bunch of 2-element sorted arrays
* Then merge those sorted arrays (left/right siblings) to end up with a bunch of 4-element sorted arrays
* Repeat until you have single sorted array
* Not in-place.  Use temporary arrays

<table>
    <tr>
        <td>
            <img width="400" alt="merge sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_014.png">
        </td>
    </tr>
</table> 


### 5.4 Merge sort - merging process
* We merge sibling left and right arrays
* We create a temporary array large enough to hold all the elements in the arrays we're merging
* We set i to the first index of the left array, and j to the first index of the right array
* We compare left[i] to right[j].  If left is smaller, we copy it to the temp array and increment i by i.  If right is smaller, we copy it to the temp array and increment j by 1
* We repeat this process until all elements in the two arrays have been processed
* At this point, the temporary array contains the merged values in sorted order
* We then copy this temporary array back to the original input array, at the correct positions
* If the left array is at positions x to y, and the right array is at positions y+1 to z, then after the copy, positions x to z will be sorted in the original array


### 5.5 Merge sort 
* NOT an in-place algorithm (the splitting phase is in place but at merging we use temporary arrays - however with cheap memory nowadays, shouldn't dissuade from using it)
* O(nlogn) - base 2.  We're repeatedly dividing the array in half during the splitting phase
* Stable algorithm



### 6. Quick sort 
* Divide and conquer algorithm
* Recursive algorithm
* Uses a pivot element to partition the array into two parts
* Elements < pivot to its left, elements > pivot to its right
* Pivot will then be in its correct sorted position
* In-place algo
* O(nlogn) - base 2. We're repeatedly partitioning the array into two halves
* Unstable algo


### 7. Counting sort 
* Makes assumptions about the data
* Doesn't use comparisons
* Counts the number of occurrences of each value
* Only works with non-negative discrete values (can't work with floats, strings)
* Values must be within a specific range

<table>
    <tr>
        <td>
            <img width="400" alt="counting sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_015.png">
        </td>
    </tr>
</table> 

<table>
    <tr>
        <td>
            <img width="400" alt="counting sort" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_016.png">
        </td>
    </tr>
</table> 

* NOT an in-place algo
* O(n) can achieve this because we're making assumptions about the data we're sorting
* If we want the sort to be stable, we have to so do some extra steps
* Algo better when input is pretty much the same size of the counting array