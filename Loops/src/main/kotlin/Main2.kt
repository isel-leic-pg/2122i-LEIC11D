/**
 * For use in Kotlin versions prior to 1.6
 */
//fun readln() = readLine()!!
//fun readlnOrNull() = readLine()

/**
 * Prints all lines read from standard input and, at the end, displays the total number of lines.
 */
fun main() {
    var line = readlnOrNull()
    var numberOfLines = 0
    while ( line !=null ) {
        println( line )
        line = readlnOrNull()
        numberOfLines++
    }
    println("Total = $numberOfLines")
}