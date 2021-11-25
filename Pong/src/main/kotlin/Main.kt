import pt.isel.canvas.*

const val FRAMES_SECOND = 50
const val PERIOD_MOVE = 1000 / FRAMES_SECOND //in milliseconds.

/**
 * Entry point of application.
 * The game has several balls that move and reflect on the walls (top, bottom and left)
 * On the right side there is no wall, but it has a racket controlled with mouse movements.
 * A new ball appears every 3 seconds.
 */
fun main() {
    onStart {
        val arena = Canvas(600,300)
        var game = game(arena.width, arena.height)
        game = game.createBall()
        arena.onTimeProgress(PERIOD_MOVE) {
            game = game.moveBalls()
            arena.drawGame(game)
        }
        arena.onTimeProgress(3000) {
            game = game.createBall()
        }
        arena.onMouseMove { me: MouseEvent ->
            game = game.moveRacket(me.y)
        }
    }
    onFinish {  }
}
