import java.io.BufferedReader
import java.io.InputStreamReader

//  알파벳 찾기

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine().toCharArray()

    val list = IntArray(26) { -1 }

    var idx = 0
    for (c in line) {
        if (list[c.code - 'a'.code] == -1) {
            list[c.code - 'a'.code] = idx
        }
        idx ++
    }

    print(list.joinToString(" "))

}
