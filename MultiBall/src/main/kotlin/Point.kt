
/**
 * Represents a position in an area (2D).
 * @property x Positive x-axis value
 * @property y Positive y-axis value
 */
data class Point(val x: Int, val y: Int)

/**
 * Represents a two-dimensional displacement.
 * @property dx x-axis displacement.
 * @property dy y-axis displacement.
 */
data class Delta(val dx: Int, val dy: Int)

/**
 * Adds a displacement to a position.
 * @receiver Original position
 * @param d Displacement to add
 * @return The resulting position
 */
operator fun Point.plus(d: Delta): Point = Point(x+d.dx, y+d.dy )
