import kotlin.test.*

class PointTest {
    @Test
    fun createPoint() {
        val p = Point(100,200)
        assertEquals(100,p.x)
        assertEquals(200,p.y)
    }
    @Test
    fun createDelta() {
        val d = Delta(5,-3)
        assertEquals(5,d.dx)
        assertEquals(-3,d.dy)
        assertEquals(Delta(5,-3), d)
    }
    @Test
    fun addPointDelta() {
        val res = Point(100,200) + Delta(5,-5)
        assertEquals(Point(105,195), res)
        assertEquals(Point(95,85), Point(100,100).plus(Delta(-5,-15)))
    }
}
