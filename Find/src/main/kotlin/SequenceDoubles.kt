/**
 * Makes a list of sequential real values within a range with a given step.
 * @param min Minimum value of randoms
 * @param max Maximum value of randoms
 * @param step Step between values
 */
fun sequenceDoubles(min: Double, max: Double, step:Double): List<Double> =
    List( ((max-min)/step).toInt() + 1 ) { idx -> min + step * idx }