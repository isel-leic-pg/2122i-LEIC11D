/**
 * Gets the value pairs that meet a [condition].
 */
fun List<Int>.find2Numbers( condition: (Int,Int)->Boolean ): List< Pair<Int,Int> > {
    var result: List< Pair<Int,Int> > = emptyList()
    for(i in 0..size-2)
        for(j in i+1 until size)
            if ( condition(this[i],this[j]) )
                result = result + Pair(this[i], this[j])
    return result
}

const val SUM = 2022

/**
 * Displays the pairs of values, read from the standard input, whose sum is 2022
 */
fun main() {
    val numbers = readLines().map { it.toInt() }
    val pairs = numbers.find2Numbers { a, b -> a+b==SUM }
    for( p in pairs )
        println("${p.first} + ${p.second} = $SUM")

    /*
    //a + b == 2021 ?
    for(idxA in 0 .. numbers.size-2 ) {
        val a = numbers[idxA]
        for(idxB in idxA+1 .. numbers.size-1) {
            val b = numbers[idxB]
            //println("a=$a , b=$b")
            if ( a+b == 2022) {
                println("$a+$b = 2022")
                //return
            }
        }
    }
     */
}
