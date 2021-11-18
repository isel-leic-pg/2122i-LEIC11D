
const val RADIUS_BALL = 30

/**
 * Represents position and movement of ball.
 * @property center Center of the ball
 * @property shift Movement of the ball
 */
data class Ball(val center: Point, val shift: Delta, val color: Int)

/**
 * Generates a random shift component for the ball on the x-axis or y-axis.
 */
private fun randomShiftAxis() = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()

/**
 * Generate a random movement for the Ball.
 */
private fun randomDelta() = Delta( randomShiftAxis(), randomShiftAxis() )

private fun randomColor() = (0x0000FF..0xFFFFFF).random()

fun ball(x: Int, y:Int): Ball =
    Ball( Point(x,y), randomDelta(), randomColor())

/**
 * Moves the Ball by its movement.
 * @receiver The original Ball
 * @param width Width of arena
 * @param height Height of arena
 * @return The new Ball after movement
 */
fun Ball?.moved(width: Int, height:Int): Ball? {
    if (this==null)
        return null
    val c = center + shift
    val reflectVertical = c.x < RADIUS_BALL && shift.dx < 0 ||
            c.x > width-RADIUS_BALL && shift.dx > 0
    val reflectHorizontal = c.y < RADIUS_BALL && shift.dy < 0 ||
            c.y > height-RADIUS_BALL && shift.dy > 0
    val delta = Delta(
        if (reflectVertical) -shift.dx else shift.dx,
        if (reflectHorizontal) -shift.dy else shift.dy
    )
    return Ball( center+delta, delta, color)
}


