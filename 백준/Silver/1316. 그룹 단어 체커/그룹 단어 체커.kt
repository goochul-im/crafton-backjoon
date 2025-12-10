import java.io.BufferedReader
import java.io.InputStreamReader

//  그룹 단어 체커

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val T = br.readLine().toInt()
    var count = 0

    outer@ for (t in 0 until T) {

        val line = br.readLine().toCharArray()
        val set = mutableSetOf<Char>()

        var i = 0
        while (i < line.size) {
            if (line[i] in set) {
                continue@outer
            } else {
                set.add(line[i])
                val target = line[i]
                while (i < line.size && line[i] == target) {
                    i++
                }
            }
        }

        count++
    }

    print(count)
}
