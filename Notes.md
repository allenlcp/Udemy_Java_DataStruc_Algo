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


###

## Arrays
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

<img width="300" alt="arrays" src="https://github.com//allenlcp/Udemy_Java_DataStruc_Algo/blob/master/resources/images/img_001.png">




