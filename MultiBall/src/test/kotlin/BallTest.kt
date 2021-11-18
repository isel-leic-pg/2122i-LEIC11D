import kotlin.test.*

class BallTest {
    @Test
    fun createBall() {
        val b = Ball(Point(100,200),Delta(5,-5),0)
        assertEquals(Point(100,200),b.center)
        assertEquals(Delta(5,-5),b.shift)
        println("ball = $b")
    }
    @Test
    fun reflectRight() {
        val b = Ball(Point(100,200),Delta(5,-5),0)
        val afterBall = b.moved(132,300)
        assertEquals(Point(95,195),afterBall.center)
        assertEquals(Delta(-5,-5),afterBall.shift)
    }
}

