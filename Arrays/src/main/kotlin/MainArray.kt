fun main() {
    val a1: Array<Int> = arrayOf(0,5,10,15,20,25)
    show(a1)
    val a2 = (0..25 step 5).toList().toTypedArray()
    show(a2)
    println(a1==a2)
    val a3 = Array(6){ it*5 }
    show(a3)
}

fun show(a:Array<Int>) {
    println(a.joinToString(separator = ";", prefix = "{", postfix = "}") { it.toString() })
}