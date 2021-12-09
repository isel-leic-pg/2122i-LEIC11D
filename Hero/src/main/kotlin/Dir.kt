import pt.isel.canvas.*

/**
 * The four possible directions.
 * @property keyCode Key code associated with direction
 */
enum class Dir(val keyCode:Int) {
    DOWN(DOWN_CODE),
    LEFT(LEFT_CODE),
    RIGHT(RIGHT_CODE),
    UP(UP_CODE)
}

/**
 * Returns the direction associated with the key code.
 * @return The direction or null if there is no direction for this key.
 */
fun Int.keyCodeToDir(): Dir? = Dir.values().firstOrNull { it.keyCode == this }