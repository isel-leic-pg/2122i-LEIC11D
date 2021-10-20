
fun readln() = readLine()!!

fun main() {
	print("Symbolo? ")
	val symb = readln().first()
	if (symb in '0'..'9')
		println("Digito")
	else {
		val upperCase = symb in 'A'..'Z'
		if (upperCase || symb in 'a'..'z') {
			val DIF = 'a'-'A'
			println("Letra")
			println(symb + if (upperCase) DIF else	-DIF)
		}
	}
	println("Fim.")
}