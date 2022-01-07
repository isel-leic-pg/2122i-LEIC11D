/**
 * Sequentially search for an element in an ordered list.
 * @param l Ordered list of elements to search for
 * @param elem Element to find
 * @return The index of the element found or null if not found
 */
fun findSequentialI(l: List<Double>, elem:Double): Int? {
    for( idx in l.indices ) {
        if (elem == l[idx])
            return idx
        if (elem < l[idx]) // Optimization in ordered list.
            return null
    }
    return null
}

/**
 * Sequentially search for an element in a list.
 * @param l Ordered list of elements to search for
 * @param elem Element to find
 * @param from Initial search index in the list
 * @return The index of the element found or null if not found
 */
tailrec fun findSequentialR(l: List<Double>, elem:Double, from: Int=0): Int? = when {
    from>=l.size || elem < l[from]  -> null
    elem == l[from]                 -> from
    else                            -> findSequentialR(l, elem, from + 1)
}

/**
 * Sequentially search for an element in a list.
 * Implementation without additional parameter "from"
 * @param l Ordered list of elements to search for
 * @param elem Element to find
 * @return The index of the element found or null if not found
 */
fun findSequentialR2(l: List<Double>, elem:Double): Int? = when {
    l.isEmpty() || elem < l.first()  -> null
    elem == l.first()                -> 0
    else                             -> findSequentialR2(l.drop(1), elem)?.let { it+1 }
    /*{
        val idx = findSequentialR2(l.drop(1), elem)
        if (idx==null) null else idx+1
    }*/
}

fun main() {
    val seqDoubles: List<Double> = sequenceDoubles(min=0.0, max=20.0, step=0.5)
    println(seqDoubles)

    val idx = findSequentialR2(seqDoubles, 13.2)
    println(idx)
}






