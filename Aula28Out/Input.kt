
fun readln() = readLine()!!

fun readString(question :String): String {
	print("$question? ")
	return readln()
}

fun readDouble(question :String) = readString(question).toDouble()

fun readInt(question :String) = readString(question).toInt()

