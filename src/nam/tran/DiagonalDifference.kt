/*
    Given a square matrix, calculate the absolute difference between the sums of its diagonals.

    For example, the square matrix arr is shown below:
        1 2 3
        4 5 6
        9 8 9

    The left-to-right diagonal = 1 + 5 + 9 = 15. The right to left diagonal = 3 + 5 + 9 =17. Their absolute difference
    is |15 - 17| = 2.

    Function description

    Complete the diagonalDifference function in the editor below.

    diagonalDifference takes the following parameter:
        int arr[n][m]: an array of integers

    Return
        int: the absolute diagonal difference

    Input Format

    The first line contains a single integer, n, the number of rows and columns in the square matrix arr.
    Each of the next n lines describes a row, arr[i], and consists of n space-separated integers arr[i][j].

    Constraints
    -100 <= a[i][j] <= 100

    Output Format

    Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

    Sample Input
        3
        11 2 4
        4 5 6
        10 8 -12

    Sample Output
        15

    Explanation

    The primary diagonal is:
        11
           5
             -12

    Sum across the primary diagonal: 11 + 5 - 12 = 4

    The secondary diagonal is:
             4
           5
        10

    Sum across the secondary diagonal: 4 + 5 + 10 = 19
    Difference: |4 - 19| = 15

    Note: |x| is the absolute value of x
*/
package nam.tran

import kotlin.math.abs

/*
 * Complete the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var sum1 = 0
    var sum2 = 0
    var count1 = 0
    var count2 = arr.size - 1
    arr.forEachIndexed { i, row ->
//        System.out.println("index : $i")
        row.forEachIndexed { j, column ->
//            System.out.println(column)
            if (j == count1)
                sum1 += column
            if (j == count2)
                sum2 += column
        }
        count1++
        count2--
    }
    return abs(sum1 - sum2)
}

fun main() {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}