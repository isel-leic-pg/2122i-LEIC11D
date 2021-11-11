import pt.isel.canvas.*

const val DELTA_MAX_BALL = 10
const val RADIUS_BALL = 30
const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.


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

operator fun Point.plus(d: Delta): Point = Point(x+d.dx, y+d.dy )

fun Ball.moved(cv: Canvas): Ball {
    val c = center + shift
    val reflectVertical = c.x < RADIUS_BALL && shift.dx < 0 || c.x > cv.width-RADIUS_BALL && shift.dx > 0
    val reflectHorizontal = c.y < RADIUS_BALL && shift.dy < 0 || c.y > cv.height-RADIUS_BALL && shift.dy > 0
    val delta = Delta(
        if (reflectVertical) -shift.dx else shift.dx,
        if (reflectHorizontal) -shift.dy else shift.dy
    )
    return Ball( center+delta , delta)
}

fun randomInt() = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()
fun randomDelta() = Delta( randomInt(), randomInt() )

fun main() {
    onStart {
        val arena = Canvas(600,300)
        var ball = Ball( Point(arena.width/2, arena.height/2), randomDelta() )
        arena.drawBall(ball)
        arena.onTimeProgress(PERIOD_MOVE) { time ->
            ball = ball.moved(arena)
            arena.drawBall(ball)
        }
        arena.onMouseDown { me: MouseEvent ->
            ball = Ball( Point(me.x, me.y), randomDelta())
        }
    }
    onFinish {  }
}