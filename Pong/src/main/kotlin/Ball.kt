
const val RADIUS_BALL = 30
const val DELTA_MAX_BALL = 10   // Maximum displacement of the ball in x-axis or in y-axis.

/**
 * Represents position and movement of ball.
 * @property center Center of the ball
 * @property shift Movement of the ball
 */
data class Ball(val center: Point, val shift: Delta, val color: Int)


//Generates a random shift component for the ball on the x-axis or y-axis.
private fun randomShiftAxis() = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()

// Generate a random movement for the Ball.
private fun randomDelta() = Delta( randomShiftAxis(), randomShiftAxis() )

// Generate a random color for the Ball
private fun randomColor() = (0x0000FF..0xFFFFFF).random()

/**
 * Creates a ball with the center positioned at ([x],[y]), with a random direction and color.
 * @param x position in x-axis of center
 * @param y position in y-axis of center
 * @return The ball created
 */
fun ball(x: Int, y:Int): Ball =
    Ball( Point(x,y), randomDelta(), randomColor())

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
    return Ball( center+delta, delta, color)
}

/**
 * Checks if a point ([x],[y]) is contained in the area of the ball.
 * @param x position in x-axis of the point
 * @param y position in y-axis of the point
 * @return true if the point is contained in the area or false otherwise.
 */
fun Ball.clicked(x: Int, y:Int): Boolean =
    ( Point(x,y) - center ).length() <= RADIUS_BALL

