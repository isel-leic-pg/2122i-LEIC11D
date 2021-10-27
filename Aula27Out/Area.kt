
val PI = 3.14159

fun circleArea(radius :Double) = PI * radius * radius

fun main(): Unit {
    val r = readDouble("raio")
	if (r<0) return
    val area = circleArea( r )
    println("área = $area")
}
