
fun leapYear(y: Int) = y%4==0 && y%100!=0 || y%400==0

fun main() {
	val m = readInt("Mês(1..12)")
	val (days,feb) = when (m) {
		1,3,5,7,8,10,12 -> 31 to ""
		2 -> {
		  val year = readInt("Ano(1900..3000)")
		  (if(leapYear(year)) 29 else 28) to "do ano $year "
		}
		else -> 30 to ""
	}
	println("O mês $m ${feb}tem $days dias.")
}