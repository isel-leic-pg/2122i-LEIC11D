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
fun findSequentialR(l: List<Double>, elem:Double, from: Int=0): Int? {
    if (from>=l.size)
        return null
    if (elem == l[from])
        return from
    return findSequentialR(l, elem, from + 1)
}