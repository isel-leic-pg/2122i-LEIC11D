/**
 * Represents the game information.
 * @property balls all ball in game (maybe an empty list)
 * @property racket racket of right side
 */
data class Game(val balls: List<Ball>, val racket:Racket)

/**
 * Creates the initial game.
 * @param width Arena game width.
 * @param height Arena game height.
 * @return The game created.
 */
fun game(width: Int, height:Int) =
    Game(
        listOf( ball(20,20), ball(100,100) ),
        racket(width, height)
    )

/**
 * Moves the racket of the game.
 * @param y New y position of racket
 * @return The new Game status with racket moved.
 */
fun Game.moveRacket(y: Int) =
    Game(balls, racket.moveTo(y) )