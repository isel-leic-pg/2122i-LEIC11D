
/* Só existe na versão 1.6 do Kotlin */
fun readln():String = readLine()!!

/* Programa:
  Soma dois valores */
fun main() {
  print("a? ")
  val a: Int = readln().trim().toInt()
  print("b? ")
  val b: Int = readln().trim().toInt()
  // val sum = a+b
  println("$a+$b = ${a+b}")
}