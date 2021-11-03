import pt.isel.canvas.*

fun main() {
    println("Begin.")
    onStart {
        val arena = Canvas(300, 200, CYAN)
        arena.drawCircle(150,100,50, GREEN,10)
        arena.drawCircle(150,100,10, RED)
        println("Start.")
        arena.onKeyPressed { key ->
            println("${key.code}")
        }
        arena.onMouseDown { me ->
            arena.drawCircle(me.x,me.y,5, BLACK)
        }
    }
    onFinish {
        println("Bye.")
    }
    println("End.")
}