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
* None dynamic data structure - fix in size - done at init
  * indices are zero based