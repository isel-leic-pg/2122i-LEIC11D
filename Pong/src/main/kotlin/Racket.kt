const val RACKET_HEIGHT = 100
const val RACKET_WIDTH = 10
const val RACKET_VERTICAL = 20

/**
 * Represents the racket.
 * @property pos Midpoint on the left side.
 */
data class Racket(val pos: Point)

/**
 * Creates the initial racket.
 * @param width Arena game width.
 * @param height Arena game height.
 * @return The racket created.
 */
fun racket(width: Int, height:Int) =
    Racket( Point(width-RACKET_VERTICAL, height/2) )

/**
 * Moves the racket.
 * @receiver The actual racket
 * @param y New y position of racket.
 * @return The new racket moved to [y].
 */
fun Racket.moveTo(y: Int) = Racket(Point(pos.x, y))