

//  Tipo da função :  (Char, (Int,Int)->Int )->Unit
fun op(oper: Char, fx: (Int,Int)->Int ) {
	val a = readInt("A")
	val b = readInt("B")
	val res = fx(a,b)
	println("$a $oper $b = $res")
}

fun add(a:Int,b:Int) = a+b
fun sub(a:Int,b:Int) = a-b
fun mult(a:Int,b:Int) = a*b
fun dollar(x:Int,y:Int) = x+y*2

fun main() {
    op('+',::add)
	op('-',::sub)
	op('x',::mult)
	op('$',::dollar)
}