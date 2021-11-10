import pt.isel.canvas.*

const val DELTA_MAX_BALL = 10
const val RADIUS_BALL = 30
const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.
const val CANVAS_WIDTH = 600
const val LIMIT_RIGHT = CANVAS_WIDTH-RADIUS_BALL
const val LIMIT_LEFT = RADIUS_BALL

data class Point(val x: Int, val y: Int)
data class Delta(val dx: Int, val dy: Int)

data class Ball(val center: Point, val shift: Delta)

fun Canvas.drawCircle(c: Point, radius: Int, color: Int) {
    drawCircle(c.x, c.y, radius, color)
}

fun Canvas.drawBall(b: Ball) {
    erase()
    drawCircle(b.center, RADIUS_BALL, RED)
}

fun Ball.moved(): Ball {
    /*
    val dx = when {
        center.x+deltaX < LIMIT_LEFT ->  DELTA_X_BALL
        center.x+deltaX > LIMIT_RIGHT -> -DELTA_X_BALL
        else -> deltaX
    }
     */
    val c = Point( center.x+shift.dx , center.y+shift.dy )
    return Ball(c,shift)
}

fun randomInt() = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()
fun randomDelta() = Delta( randomInt(), randomInt() )

fun main() {
    onStart {
        val arena = Canvas(CANVAS_WIDTH,300)
        var ball = Ball( Point(arena.width/2, arena.height/2), randomDelta() )
        arena.drawBall(ball)
        arena.onTimeProgress(PERIOD_MOVE) { time ->
            ball = ball.moved()
            arena.drawBall(ball)
        }
        arena.onMouseDown { me: MouseEvent ->
            ball = Ball( Point(me.x, me.y), randomDelta())
        }
    }
    onFinish {  }
}