import pt.isel.canvas.*

/**
 * Draws a circle on Canvas.
 * Used only to receive a point as the center instead of two parameters of type Int.
 */
private fun Canvas.drawCircle(c: Point, radius: Int, color: Int) {
    drawCircle(c.x, c.y, radius, color)
}

/**
 * Show all balls in canvas and the number os balls.
 * @receiver Canvas where balls is showed.
 * @param bs Current list of balls
 */
fun Canvas.drawBalls(bs: List<Ball>) {
    drawText(0,height,"${bs.size}")
    bs.forEach { b ->
        drawCircle(b.center, RADIUS_BALL, b.color)
    }
}

/**
 * Show racket in canvas.
 * @receiver Canvas where racket is showed.
 * @param r Current racket to show.
 */
fun Canvas.drawRacket(r: Racket) {
    drawRect(
        r.pos.x, r.pos.y-RACKET_HEIGHT/2,
        RACKET_WIDTH, RACKET_HEIGHT, GREEN
    )
}

/**
 * Show all game (balls and racket)
 * @receiver Canvas where game is showed.
 * @param g Current state of the game.
 */
fun Canvas.drawGame(g: Game) {
    erase()
    drawBalls(g.balls)
    drawRacket(g.racket)
}