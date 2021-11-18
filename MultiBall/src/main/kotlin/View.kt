import pt.isel.canvas.*

/**
 * Draws a circle on Canvas.
 * Used only to receive a point as the center instead of two parameters of type Int.
 */
private fun Canvas.drawCircle(c: Point, radius: Int, color: Int) {
    drawCircle(c.x, c.y, radius, color)
}


/**
 * Show the ball in canvas.
 * @receiver Canvas where the ball is showed.
 * @param b Ball to be showed.
 */
fun Canvas.drawBall(b: Ball?) {
    erase()
    if (b!=null)
        drawCircle(b.center, RADIUS_BALL, b.color)
}

/**
 * Show all balls in canvas and the number os balls.
 * @receiver Canvas where balls is showed.
 * @param bs Current list of balls
 */
fun Canvas.drawBalls(bs: List<Ball>) {
    erase()
    drawText(0,height,"${bs.size}")
    bs.forEach { b ->
        drawCircle(b.center, RADIUS_BALL, b.color)
    }
}