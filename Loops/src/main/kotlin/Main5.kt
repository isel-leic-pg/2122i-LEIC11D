
fun sumAll1(values: List<Int>): Int {
    var sum = 0
    var index = 0
    while ( index < values.size ) {
        sum += values[ index ]
        index++
    }
    return sum
}

/**
 * Sum all values in the list [values]
 * @return Total sum value
 */
fun sumAll(values: List<Int>): Int {
    var sum = 0
    for(value in values) sum += value
    return sum
}

/**
 * Shows the average of all values read from the standard input (one per line).
 */
fun main() {
    val lines: List<String> = readLines()
    val numbers: List<Int> = lines.map { it.toInt() }
    val total = sumAll(numbers)
    val avg = total.toDouble() / numbers.size
    println("Média = $avg")
}