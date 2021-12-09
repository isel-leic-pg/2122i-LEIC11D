import pt.isel.canvas.Canvas

const val CELL_SIDE = 64            // Width of each image square in the file.
const val HERO_SIZE = CELL_SIDE*2   // Width of hero square displayed in arena.
const val HERO_STEP = 4             // Step of each hero's move.

/**
 * Represents the hero
 * @property dir Direction to where it is facing
 * @property pos Position where it are (image center point)
 */
data class Hero(val dir: Dir, val pos: Point)

/**
 * Create the starting hero.
 * In the center of the arena facing down.
 */
fun hero(cv: Canvas) =
    Hero(Dir.DOWN, Point(cv.width / 2 - HERO_SIZE / 2, cv.height / 2 - HERO_SIZE / 2))

/**
 * Turn the hero in the indicated direction if facing the other way.
 * Move the hero to the indicated direction if he is already facing to that way.
 * @receiver Actual Hero
 * @param dir Direction to turn or move
 * @return The new Hero
 */
fun Hero.process(dir: Dir): Hero {
    if (dir != this.dir) return copy( dir= dir )
    val pos = when(dir) {
        Dir.UP -> Point(pos.x, pos.y-HERO_STEP)
        Dir.DOWN -> Point(pos.x, pos.y+HERO_STEP)
        Dir.LEFT -> Point(pos.x-HERO_STEP, pos.y)
        Dir.RIGHT -> Point(pos.x+HERO_STEP, pos.y)
    }
    return copy( pos = pos )
}

/**
 * Draw the hero.
 */
fun Canvas.drawHero(hero: Hero) {
    erase()
    val sy = CELL_SIDE * hero.dir.ordinal
    drawImage("Hero|0,$sy,$CELL_SIDE,$CELL_SIDE",
        hero.pos.x, hero.pos.y, HERO_SIZE, HERO_SIZE
    )
}