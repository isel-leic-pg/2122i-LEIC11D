import pt.isel.canvas.*

const val RADIUS_BALL = 30

/**
 * Represents position and movement of ball.
 * @property center Center of the ball
 * @property shift Movement of the ball
 */
data class Ball(val center: Point, val shift: Delta)

/**
 * Moves the Ball by its movement.
 * @receiver The original Ball
 * @param width Width of arena
 * @param height Height of arena
 * @return The new Ball after movement
 */
fun Ball.moved(width: Int, height:Int): Ball {
    val c = center + shift
    val reflectVertical = c.x < RADIUS_BALL && shift.dx < 0 ||
            c.x > width-RADIUS_BALL && shift.dx > 0
    val reflectHorizontal = c.y < RADIUS_BALL && shift.dy < 0 ||
            c.y > height-RADIUS_BALL && shift.dy > 0
    val delta = Delta(
        if (reflectVertical) -shift.dx else shift.dx,
        if (reflectHorizontal) -shift.dy else shift.dy
    )
    return Ball( center+delta , delta)
}

/**
 * Show the ball in canvas.
 * @receiver Canvas where the ball is showed.
 * @param b Ball to be showed.
 */
fun Canvas.drawBall(b: Ball) {
    erase()
    drawCircle(b.center, RADIUS_BALL, RED)
}
