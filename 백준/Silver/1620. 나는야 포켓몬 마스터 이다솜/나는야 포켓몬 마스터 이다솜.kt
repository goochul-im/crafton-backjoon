import java.io.BufferedReader
import java.io.InputStreamReader

//  나는야 포켓몬 마스터 이다솜

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N , M) = br.readLine().split(" ").map { it.toInt() }

    val intKeyMap = mutableMapOf<Int, String>()
    val stringKeyMap = mutableMapOf<String, Int>()

    for (i in 1..N) {
        val name = br.readLine()
        intKeyMap[i] = name
        stringKeyMap[name] = i
    }

    for (i in 1..M) {
        val find = br.readLine()
        if (find.toIntOrNull() == null) {
            println(stringKeyMap[find])
        } else {
            println(intKeyMap[find.toInt()])
        }
    }

}
