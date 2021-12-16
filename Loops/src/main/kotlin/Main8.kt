/**
 * Alternative implementation of forEachIndexed function
 */
fun <T> List<T>.myForEach( action: (Int,T)->Unit ) {
    /*
    var idx=0
    for (e in this)
        action(idx++,e)
     */
    var idx = 0
    while ( idx < size ) {
        action( idx, this[idx] )
        idx++
    }
}

/**
 * Alternative implementation of map function
 */
fun <T,U> List<T>.myMap( transform: (T)->U ): List<U> {
    var result: List<U> = emptyList()
    for (e in this)
        result = result + transform(e)
    return result
}

/**
 * Program to test myForEach and myMap
 */
fun main() {
    val lst = listOf(2,4,7,15)
    lst.myForEach{ i, value ->
       println("[$i] = $value")
    }
    val ls = lst.myMap{ "($it)" }
    println(ls)
}