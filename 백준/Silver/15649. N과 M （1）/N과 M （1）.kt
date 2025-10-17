import java.io.BufferedReader
import java.io.InputStreamReader

//  N과 M (1)

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N,M) = br.readLine().split(" ").map { it.toInt() }

    fun dfs(depth: Int, before: MutableList<Int>) {
        if (depth == M) {
            println(before.joinToString(" "))
        }

        for (i in 1..N) {
            if (!before.contains(i)) {
                before.add(i)
                dfs(depth + 1, before)
                before.remove(i)
            }
        }

    }

    dfs(0, mutableListOf())

}
