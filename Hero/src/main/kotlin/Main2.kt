import pt.isel.canvas.*
/*
const val CELL_SIDE = 64
const val HERO_SIZE = CELL_SIDE*2

enum class Dir(val keyCode:Int) {
    DOWN(DOWN_CODE),
    LEFT(LEFT_CODE),
    RIGHT(RIGHT_CODE),
    UP(UP_CODE)
}

fun Canvas.drawHero(dir: Dir) {
    erase()
    val sy = CELL_SIDE * dir.ordinal
    drawImage("Hero|0,$sy,$CELL_SIDE,$CELL_SIDE",
        width/2-HERO_SIZE/2, height/2-HERO_SIZE/2,HERO_SIZE,HERO_SIZE)
}

fun Int.toDir(): Dir? = Dir.values().firstOrNull { it.keyCode == this }

fun main() {
    onStart {
        val cv = Canvas(800,500, WHITE)
        var dir: Dir = Dir.DOWN
        cv.drawHero(dir)
        cv.onKeyPressed { ke ->
            dir = ke.code.toDir() ?: return@onKeyPressed
            cv.drawHero(dir)
        }
    }
    onFinish {  }
} */