

//  Tipo da função :  (Char, (Int,Int)->Int )->Unit
fun op(oper: Char, fx: (Int,Int)->Int ) {
	val a = readInt("A")
	val b = readInt("B")
	val res = fx(a,b)
	println("$a $oper $b = $res")
}

fun main() {
    op('+'){a,b->a+b}
	op('-') { a, b ->
		a - b
	}
	fun m(x:Int,y:Int) = x*y
	op('x',::m)
	
	val factor = 10
	fun dollar(a:Int, b:Int) = (a+b)*factor
	op('$',::dollar)
}