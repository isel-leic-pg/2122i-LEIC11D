

fun readWords(quest:String):List<String> {
    print("$quest? ")
    return readln().split(' ').filter { it.isNotEmpty() }
}

fun readValues(quest: String):List<Int> {
    val l = readWords(quest)
    //return l.filter { it.all{ ch -> ch.isDigit() }  }.map { it.toInt() }
    return l.mapNotNull{ it.toIntOrNull() }
}

data class Time(val hours:Int, val minutes:Int)

fun readTime(quest: String):Time? {
    val hm = readValues("$quest (H M)")
    if (hm.size != 2) return null
    val (h,m) = hm
    return if (h in 0..23 && m in 0..59) Time(h,m) else null
}

fun readValidTime(quest: String):Time {
    while (true) {
        val tm = readTime(quest)
        if( tm!=null ) return tm
    }
}

fun Time.print(label: String) = println("$label = $hours:$minutes")

fun Time.toInt() = hours*60 + minutes

operator fun Time.minus(t: Time): Time {
    val m = toInt() - t.toInt()
    return Time(m / 60, m % 60)
}
/*
Indique os nomes dos locais de partida,
de paragem e de chegada pela ordem.
Locais? Alcantra Belém Oeiras Cascais
Partida de Alcantra (H M)? 8 40
Chegada a Belém (H M)? 9 05
Chegada a Oeiras (H M)? 10 13
Chegada a Cascais (H M)? 11 22
Alcantra -> Belém = 0:25
Alcantra -> Oeiras = 1:33
Alcantra -> Cascais = 2:42
*/
fun main() {
    println("Indique os nomes dos locais de partida,")
    println("de paragem e de chegada pela ordem.")
    val locals = readWords("Locais")
    val start = readValidTime("Partida de ${locals.first()}")
    val times = locals.drop(1).map{ readValidTime("Chegada a $it") }
    times.forEachIndexed { idx, tm ->
        (tm-start).print("${locals.first()} -> ${locals[idx+1]}")
    }
    /*val words = readWords("Palavras")
    println(words)
    val values = readValues("Valores")
    println(values)
    val tm = readValidTime("Tempo")
    tm.print("resultado")
    println("minutos = ${tm.toInt()}") */
    //println(Time(4,45)-Time(1,50))
}

