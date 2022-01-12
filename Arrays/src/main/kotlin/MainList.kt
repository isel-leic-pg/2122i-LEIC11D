fun main() {
    val l1: List<Int> = listOf(0,5,10,15,20,25)
    println(l1)
    val l2 = (0 .. 25 step 5).toList()
    println(l2)
    println(l1==l2)
    val l3 = List(6){ it*5 }
    println(l3)
}