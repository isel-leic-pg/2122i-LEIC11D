
fun op(oper: Char, ... ) {
	val a = readInt("A")
	val b = readInt("B")
	val res = when (oper) {
		'+' -> a + b
		'-' -> a - b
		'x' -> a * b
		else -> -1  // Code smell
	}
	println("$a $oper $b = $res")
}

fun main() {
    op('+')
	op('-')
	op('x')
	op('$')
}