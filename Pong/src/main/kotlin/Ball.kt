
const val RADIUS_BALL = 30
const val DELTA_MAX_BALL = 10   // Maximum displacement of the ball in x-axis or in y-axis.

/**
 * Represents position and movement of ball.
 * @property center Center of the ball
 * @property shift Movement of the ball
 * @property color Color of the ball
 */
data class Ball(val center: Point, val shift: Delta, val color: Int)

// Generate a random movement for the Ball.
private fun randomDelta() = Delta(
    dx = ((-DELTA_MAX_BALL..DELTA_MAX_BALL)-0).random(),
    dy = (-DELTA_MAX_BALL..DELTA_MAX_BALL).random()
)

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
 * Reflects on left, top and bottom limits.
 * The ball disappears when it exceeds the right limit.
 * @receiver The original Ball
 * @param width Width of arena
 * @param height Height of arena
 * @return The new Ball after movement and reflections or null if disappeared.
 */
fun Ball.moved(width: Int, height:Int): Ball? {
    val c = center + shift
    if (shift.dx>0 && c.x > width+RADIUS_BALL)
        return null
    val reflectVertical = c.x < RADIUS_BALL && shift.dx < 0
    val reflectHorizontal = c.y < RADIUS_BALL && shift.dy < 0 ||
            c.y > height-RADIUS_BALL && shift.dy > 0
    val delta = Delta(
        if (reflectVertical) -shift.dx else shift.dx,
        if (reflectHorizontal) -shift.dy else shift.dy
    )
    return Ball( center+delta, delta, color)
}

/**
 * Check if the ball is in collision with the racket.
 * @receiver The original Ball
 * @param r The racket
 * @return True if ball is in collision with racket.
 */
fun Ball.isInCollision(r: Racket) =
    shift.dx > 0 && center.x + RADIUS_BALL > r.pos.x &&
    center.y in r.pos.y-RACKET_HEIGHT/2 .. r.pos.y+RACKET_HEIGHT/2 &&
    center.x < r.pos.x + RACKET_WIDTH

/**
 * Returns the ball after collision with the racket or
 * returns the current ball if it does not collide.
 * @receiver The original Ball
 * @param r The racket
 * @return The ball after collision or the current ball.
 */
fun Ball.collide(r: Racket): Ball =
    if ( isInCollision(r) ) copy(shift = Delta(-shift.dx,shift.dy))
    else this
