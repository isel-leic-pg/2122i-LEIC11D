/**
* Makes a list of random integer values within a range.
* @param size Number of values
* @param min Minimum value of randoms
* @param max Maximum value of randoms
* Implementation with immutable list using a while loop.
*/
fun randomIntsA(size: Int, min: Int, max: Int) : List<Int> {
    var result = emptyList<Int>()
    var i = 0
    while(i < size) {
        result = result + (min..max).random()
        i++
    }
    return result
}

/** Implementation with immutable list using a repeat loop. */
fun randomIntsB(size: Int, min: Int, max: Int) : List<Int> {
    var result = emptyList<Int>()
    //for(i in 0 until size)
    repeat(size) {
        result = result + (min..max).random()
    }
    return result
}

/** Implementation with mutable list using a repeat loop. */
fun randomIntsC(size: Int, min: Int, max: Int) : List<Int> {
    val result: MutableList<Int> = mutableListOf()
    repeat(size) {
        result.add( (min..max).random() )
    }
    return result
}

/** Implementation with list construction with elements created with a function. */
fun randomInts(size: Int, min: Int, max: Int) = List(size) { (min..max).random() }

