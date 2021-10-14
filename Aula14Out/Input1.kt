
fun readln():String = readLine()!!

fun main() {
  val name: String
  print("Nome? ")
  name = readln()
  println("Olá ${name}x")
}