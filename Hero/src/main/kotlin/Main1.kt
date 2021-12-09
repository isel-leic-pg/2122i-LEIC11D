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

fun drawHero(c: Canvas, dir: Dir) {
    c.erase()
    val sy = CELL_SIDE * dir.ordinal
    /*val sy = when(dir) {
        Dir.DOWN -> CELL_SIDE*0
        Dir.LEFT -> CELL_SIDE*1
        Dir.RIGHT -> CELL_SIDE*2
        Dir.UP -> CELL_SIDE*3
    }*/
    c.drawImage("Hero|0,$sy,$CELL_SIDE,$CELL_SIDE",
        c.width/2-HERO_SIZE/2, c.height/2-HERO_SIZE/2,HERO_SIZE,HERO_SIZE)
}

fun Int.toDir(): Dir? =
    Dir.values().firstOrNull { it.keyCode == this }
    /*when(this) {
        DOWN_CODE -> Dir.DOWN
        UP_CODE -> Dir.UP
        LEFT_CODE -> Dir.LEFT
        RIGHT_CODE -> Dir.RIGHT
        else -> null
    }*/


fun main() {
    onStart {
        val cv = Canvas(800,500, WHITE)
        var dir: Dir = Dir.DOWN
        drawHero(cv,dir)
        cv.onKeyPressed { ke ->
            val d = ke.code.toDir()
            if (d!=null) {
                dir = d
                drawHero(cv, dir)
            }
        }
    }
    onFinish {  }
} */