/* Só existe na versão 1.6 do Kotlin */
fun readln():String = readLine()!!

fun main() {
  print("Simbolo? ")
  /*
  val line = readln()
  val symb: Char = line[0]
  val code = symb.toInt()
  val hex: String = code.toString(16)
  println("Código de $symb = $code ($hex)")
  */
  val symb = readln()[0] 
  val code = symb.toInt()
  println("Código de \'$symb\' = $code (${code.toString(16)})")
}