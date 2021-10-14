
/* Só existe na versão 1.6 do Kotlin */
fun readln():String = readLine()!!

fun main() {
  print("Simbolo? ")
  val symb = readln()[0] 
  val letter: Boolean = symb>='A' && symb<='Z' || symb in 'a'..'z'
  println("$symb é letra ($letter)")
}