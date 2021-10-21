
fun readln() = readLine()!!

fun main() {
	print("Symbolo? ")
	when (val symb =readln().first()) {
		in '0'..'9' -> println("Digito")
		in 'A'..'Z' , in 'a'..'z'  -> { 
			val DIF = 'a'-'A'
			println("Letra")
			println(symb + if(symb in 'A'..'Z') DIF else -DIF)
		}
	}
	println("Fim.")
}