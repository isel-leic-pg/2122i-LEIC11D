import pt.isel.canvas.*

const val DELTA_MAX_BALL = 10   // Maximum displacement of the ball in x-axis or in y-axis.
const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.

/**
 * Draws a circle on Canvas.
 * Used only to receive a point as the center instead of two parameters of type Int.
 */
fun Canvas.drawCircle(c: Point, radius: Int, color: Int) {
    drawCircle(c.x, c.y, radius, color)
}

/**
 * Generates a random shift component for the ball on the x-axis or y-axis.
 */
fun randomInt() = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()

/**
 * Generate a random movement for the Ball.
 */
fun randomDelta() = Delta( randomInt(), randomInt() )

/**
 * Entry point of application.
 * Ball that moves in a random direction in an arena.
 * Each click repositions the ball in a random direction.
 */
fun main() {
    onStart {
        val arena = Canvas(600,300)
        var ball = Ball( Point(arena.width/2, arena.height/2), randomDelta() )
        arena.drawBall(ball)
        arena.onTimeProgress(PERIOD_MOVE) { time ->
            ball = ball.moved(arena.width,arena.height)
            arena.drawBall(ball)
        }
        arena.onMouseDown { me: MouseEvent ->
            ball = Ball( Point(me.x, me.y), randomDelta())
        }
    }
    onFinish {  }
}