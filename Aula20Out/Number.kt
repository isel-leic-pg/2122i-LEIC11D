
fun readln() = readLine()!!

fun main() {
	print("Valor? ")
	val number = readln().trim().toInt()
	println(number)
	val positive: Boolean
	if (number>=0) {
		println("Positivo")
		positive = true
	}
	else { //if (number<0) 
		println("Negativo")
		positive = false
	}
	println("Positive=$positive")
}