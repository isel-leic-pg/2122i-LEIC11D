fun main() {
    val rndInts: List<Int> = randomInts(36, min = 0 , max = 20)
    println(rndInts)
    println(rndInts.sorted())

    val seqDoubles: List<Double> = sequenceDoubles(min=0.0, max=20.0, step=0.5)
    println(seqDoubles)

    val idx = findSequentialR(seqDoubles,13.5)
    println(idx)
}