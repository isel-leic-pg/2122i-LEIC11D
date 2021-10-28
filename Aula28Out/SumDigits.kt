fun main() {
	val number = readString("Valor")
	val d1 = number.first().digitToInt()
	val d2 = number.last().digitToInt()
	println("$d1 + $d2 = ${d1+d2}")
}