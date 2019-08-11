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

<img width="500" alt="arrays" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_001.png">

* Mem start address of 12 is for illustration purposes only
* For the first element in the array we actually do the same calculation [12 + (0 * 4) = 12].  Actually we use the same formula everywhere.  Therefore, this may explain why array indices are **zero** based.  If the weren't we would have to subtract one in the formula.
* int is of size = 4 bytes
* Arrays really good a retrieving element if we know the index





## Arrays and Big-O notation

### Retrieve an Element from an Array
1. Multiply the size of the element by its index
2. Get the start address of the array
3. Add the start address to the result of the multiplication

### Retrieve an Element from an Array - when we know the index
* Therefore it doesn't matter how big is the array, we **only** have these 3 steps to find the element.  The steps to retrieve never changes. We therefore have **constant time complexity O(1)** - means as the number of item increases, the algorithm does not degrade.

### Retrieve an Element from an Array - when we do NOT know the index
* We will need to loop through the array to find element but we need to consider the worse case scenario for big-o, therefore we will assume that we will have to loop through the entire array.  As such the big-o notation is **O(n)**.


<img width="500" alt="arrays" src="https://github.com/allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_002.png">



