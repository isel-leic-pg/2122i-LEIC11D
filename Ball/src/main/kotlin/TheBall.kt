import pt.isel.canvas.*

const val DELTA_X_BALL = 4
const val RADIUS_BALL = 80
const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.
const val CANVAS_WIDTH = 600
const val LIMIT_RIGHT = CANVAS_WIDTH-RADIUS_BALL
const val LIMIT_LEFT = RADIUS_BALL

data class Ball(val x:Int, val y:Int, val deltaX:Int)

fun drawBall(canvas: Canvas, b: Ball) {
    canvas.erase()
    canvas.drawCircle(b.x, b.y, RADIUS_BALL, RED)
}

fun move(b: Ball): Ball = when {
    b.x in LIMIT_LEFT..LIMIT_RIGHT ->   b.copy( x= b.x+b.deltaX )
    b.x < LIMIT_LEFT ->                 Ball( b.x+DELTA_X_BALL, b.y, DELTA_X_BALL )
    /*b.x > LIMIT_RIGHT*/ else ->       Ball( b.x-DELTA_X_BALL, b.y, -DELTA_X_BALL )
}

fun main() {
    onStart {
        val arena = Canvas(CANVAS_WIDTH,300)
        var ball = Ball(RADIUS_BALL, arena.height / 2, DELTA_X_BALL)
        drawBall(arena, ball)
        arena.onTimeProgress(PERIOD_MOVE) { time ->
            ball = move(ball)
            drawBall(arena, ball)
        }
        arena.onMouseDown { me: MouseEvent ->
            ball = Ball(me.x, me.y, ball.deltaX)
        }
    }
    onFinish {  }
}