

/*
0! = 1
n! = (n-1)! * n

3! = 2! * 3  = (1! * 2) * 3  = ((0! * 1) * 2) * 3  = ((1 * 1) * 2) * 3 = 6
*/

/**
 * Recursive implementation of factorial calculation (n!)
 * @param n Base value for calculation
 * @return The result of n!
 */
fun factorialR(n: Int): Long =
    if (n == 0) 1 else factorial(n - 1) * n

/**
 * Iterative implementation of factorial calculation (n!)
 * @param n Base value for calculation
 * @return The result of n!
 */
fun factorial(n: Int): Long {
    var res = 1L
    for( v in 2..n )
        res *= v
    return res
}


fun main() {
    println(factorial(0))
    println(factorial(3))
    println(factorial(15))
    println(factorial(20))
    println(factorial(10000))
}