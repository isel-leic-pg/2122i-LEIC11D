/**
 * Recursive implementation of binary search.
 * @param l List of values to find for.
 * @param elem Value to find
 * @param start Initial index of the list to be searched for
 * @param end Final index of the list how to be searched for
 * @return The index of the element found or null if not found
 */
tailrec fun findBinaryR(l: List<Double>, elem: Double, start: Int=0, end: Int=l.lastIndex): Int? {
    if (start > end) return null
    val mid = (start+end) / 2
    return when {
        elem == l[mid] -> mid
        elem < l[mid] -> findBinaryR(l, elem, start, mid-1)
        else -> findBinaryR(l, elem, mid+1, end)
    }
}

/**
 * Iterative implementation of binary search.
 * @param l List of values to find for.
 * @param elem Value to find
 * @return The index of the element found or null if not found
 */
fun findBinary(l: List<Double>, elem: Double): Int? {
    var start = 0
    var end = l.lastIndex
    while(start <= end) {
        val mid =  (start+end) / 2
        when {
            elem == l[mid] -> return mid
            elem < l[mid] -> end = mid-1
            else -> start = mid+1
        }
    }
    return null
}


fun main() {
    val seqDoubles: List<Double> = sequenceDoubles(min=0.0, max=20.0, step=0.5)
    println(seqDoubles)

    val idx = findBinaryR(seqDoubles, 13.5)
    println(idx)
}