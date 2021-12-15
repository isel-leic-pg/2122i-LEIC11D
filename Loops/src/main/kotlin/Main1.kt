
/**
 * Reads up to 10 lines of text (from standard input) and displays those lines.
 * Assumes standard input can be redirected from a file.
 */
fun main() {
    (1..10).forEach{
        val line: String? = readLine()
        if (line!=null)
            println(line)
        else
            return
    }
}

// C:> kotlin MainKt < Lusiadas.txt