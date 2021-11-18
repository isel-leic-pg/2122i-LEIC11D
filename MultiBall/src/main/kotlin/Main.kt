import pt.isel.canvas.*

const val DELTA_MAX_BALL = 10   // Maximum displacement of the ball in x-axis or in y-axis.
const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.


/**
 * Entry point of application.
 * Ball that moves in a random direction in an arena.
 * Each click repositions the ball in a random direction.
 */
fun main() {
    onStart {
        val arena = Canvas(600,300)
        var ball: Ball? = null
        arena.onTimeProgress(PERIOD_MOVE) {
                ball = ball?.moved(arena.width, arena.height)
            arena.drawBall(ball)
        }
        arena.onMouseDown { me: MouseEvent ->
            if (ball==null)
                ball = ball(me.x, me.y)
        }
        arena.onKeyPressed {
            if (it.char==' ') ball=null
        }
    }
    onFinish {  }
}