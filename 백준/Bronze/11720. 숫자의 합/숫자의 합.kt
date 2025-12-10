import java.io.BufferedReader
import java.io.InputStreamReader

//  숫자의 합

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine()
    val line = br.readLine().toList()

    print(line.sumOf { it.toString().toInt()})

}
