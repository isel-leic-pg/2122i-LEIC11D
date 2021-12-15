/*
fun readLines(): List<String> {
    var lns = emptyList<String>()
    var line = readlnOrNull()
    while ( line!=null ) {
        lns = lns + line
        line = readlnOrNull()
    }
    return lns
}
*/

/**
 * Returns the list of all lines read from standard input.
 * This version of the function is an optimization of the version above that is commented.
 */
fun readLines(): List<String> {
    var lns = emptyList<String>()
    while (true)
        lns = lns + (readlnOrNull() ?: return lns)
}

/**
 * Prints all lines read from standard input and, at the end, displays the total number of lines.
 */
fun main() {
    val lines = readLines()
    lines.forEach { println(it) }
    println("Total = ${lines.size}")
}