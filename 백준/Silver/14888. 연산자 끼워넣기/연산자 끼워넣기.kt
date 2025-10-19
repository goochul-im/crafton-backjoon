import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

//  연산자 끼워넣기

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val prob = br.readLine().split(" ").map { it.toInt() }
    val op: IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var minAnswer = Int.MAX_VALUE
    var maxAnswer = Int.MIN_VALUE

    fun dfs(depth: Int, result: Int) {

        if (depth == N) {
            minAnswer = min(minAnswer, result)
            maxAnswer = max(maxAnswer, result)
            return
        }

        for (i in 0..3) {

            if (op[i] > 0) {
                op[i]--
                when (i) {
                    0 -> dfs(depth + 1, result + prob[depth])
                    1 -> dfs(depth + 1, result - prob[depth])
                    2 -> dfs(depth + 1, result * prob[depth])
                    3 -> dfs(depth + 1, result / prob[depth])
                }
                op[i]++
            }

        }


    }

    dfs(1, prob[0])
    println(maxAnswer)
    println(minAnswer)
}
