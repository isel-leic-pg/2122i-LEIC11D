import pt.isel.canvas.*

/**
 * Entry point of the program.
 * Move a hero according to the arrow keys.
 */
fun main() {
    onStart {
        val cv = Canvas(800,500, WHITE)
        var hero = hero(cv)
        cv.drawHero(hero)
        cv.onKeyPressed { ke ->
            val dir = ke.code.keyCodeToDir() ?: return@onKeyPressed
            hero = hero.process( dir )
            cv.drawHero(hero)
        }
    }
    onFinish {  }
}
