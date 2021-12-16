/**
 * Repeats [n] times the execution of [fx]
 */
fun myRepeat(n: Int, fx: ()->Unit) {
    var i = 0
    while (i<n) {
        fx()
        i++
    }
}

/**
 * Reads up to 10 lines of text (from standard input) and displays those lines.
 * Assumes standard input can be redirected from a file.
 */
fun main() {
    //var count = 1
    //while (count <=10) {
    //    count++
    myRepeat(10) {
    //(1..10).forEach{
        val line: String? = readLine()
        if (line!=null)
            println(line)
    }
}

// C:> kotlin MainKt < Lusiadas.txt