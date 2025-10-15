import java.io.BufferedReader
import java.io.InputStreamReader

//  문자열 집합

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val set = mutableSetOf<String>()
    for (i in 0..<N) {
        set.add(br.readLine())
    }

    var answer = 0
    for (i in 0..<M) {
        if (set.contains(br.readLine())) answer++
    }

    print(answer)
}
