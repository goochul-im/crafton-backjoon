import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    val sb = StringBuilder()

    for (i in 0 until T) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        val distance = y - x

        val max = sqrt(distance.toDouble()).toInt()

        val count = when {
            max * max == distance -> 2 * max - 1
            distance <= max * max + max -> 2 * max
            else -> 2 * max + 1
        }
        sb.append(count).append('\n')
    }
    print(sb)
}