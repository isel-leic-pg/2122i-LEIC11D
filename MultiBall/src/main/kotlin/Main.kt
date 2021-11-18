import pt.isel.canvas.*

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
        var balls: List<Ball> = listOf( ball(20,20), ball(100,100) )
        arena.onTimeProgress(PERIOD_MOVE) {
            balls = balls.map{
                it.moved(arena.width, arena.height)
            }
            arena.drawBalls(balls)
        }
        arena.onMouseDown { me: MouseEvent ->
            balls = onClick(balls, me)
        }
        arena.onKeyPressed {
            if (it.char==' ' && balls.isNotEmpty())
                balls = balls - balls.first()
        }
    }
    onFinish {  }
}

/**
 * Returns a list with minus one ball or plus one ball, depending on the click point.
 * If the click was on a ball it returns a list with minus that ball.
 * If the click was not on any ball, it returns a list with one more new ball.
 * @param balls The current list of balls
 * @param me mouse event with click information
 * @return The new list of balls
 */
private fun onClick(balls: List<Ball>, me: MouseEvent): List<Ball> {
    val clicked = balls.find { it.clicked(me.x,me.y) }
    return if (clicked!=null)
        balls - clicked
    else
        balls + ball(me.x, me.y)
}