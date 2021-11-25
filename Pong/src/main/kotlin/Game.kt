/**
 * Represents the game information.
 * @property width total width of the game arena
 * @property height total height of the game arena
 * @property balls all ball in game (maybe an empty list)
 * @property racket racket of right side
 * @property score number of collisions with the racket
 */
data class Game(
    val width: Int, val height: Int,
    val balls: List<Ball>,
    val racket:Racket,
    val score: Int
)
/**
 * Creates the initial game.
 * @param width Arena game width.
 * @param height Arena game height.
 * @return The game created.
 */
fun game(width: Int, height:Int) =
    Game(
        width, height,
        emptyList(),
        racket(width, height),
        0
    )

/**
 * Moves the racket of the game.
 * @receiver actual game.
 * @param y New y position of racket
 * @return The new Game status with racket moved.
 */
fun Game.moveRacket(y: Int) =
    copy(racket = racket.moveTo(y))
    //Game(width, height, balls, racket.moveTo(y) )

/**
 * Move the balls with reflection on the walls and racket.
 * @receiver actual game
 * @receiver The game updated with new balls and new score
 */
fun Game.moveBalls(): Game {
    val afterMove = balls.mapNotNull { ball -> ball.moved(width, height) }
    val collides = afterMove.count{ it.isInCollision(racket) }
    return copy(
        balls = afterMove.map{ it.collide(racket) },
        score = score + collides
    )
}

/**
 * Adds a new ball to the game.
 * @receiver actual game
 * @receiver The game updated with the new ball added
 */
fun Game.createBall() =
    copy( balls = balls + ball(RADIUS_BALL,height/2) )

