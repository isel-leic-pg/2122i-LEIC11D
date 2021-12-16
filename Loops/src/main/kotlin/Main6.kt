
/**
 * Shows the average of all values read from the standard input (one per line).
 * The most compact form.
 */
fun main() {
    println("Média = ${readLines().map { it.toInt() }.average()}")
    /*
    val lines: List<String> = readLines()
    val numbers: List<Int> = lines.map { it.toInt() }
    val total = numbers.sum()
    val avg = total.toDouble() / numbers.size
    println("Média = $avg")
     */
}