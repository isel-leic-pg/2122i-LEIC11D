/**
 * Returns the total number of lines that can be read from standard input.
 */
fun numberOfLines(): Int {
    var count = 0
    while ( readLine()!= null ) count++
    return count
}

/**
 * Displays the total number of lines that can be read from standard input.
 */
fun main() {
    val total = numberOfLines()
    println("Total = $total")
}