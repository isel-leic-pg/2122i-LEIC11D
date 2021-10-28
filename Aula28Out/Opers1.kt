
fun opPlus() {
	val a = readInt("A")
	val b = readInt("B")
	println("$a + $b = ${a+b}")
}
fun opMinus() {
	val a = readInt("A")
	val b = readInt("B")
	println("$a - $b = ${a-b}")
}
fun opMult() {
	val a = readInt("A")
	val b = readInt("B")
	println("$a x $b = ${a*b}")
}

fun main() {
    opPlus()
	opMinus()
	opMult()
}