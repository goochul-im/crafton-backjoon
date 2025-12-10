import java.io.BufferedReader
import java.io.InputStreamReader

//  단어 공부

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine().toCharArray().map { it.lowercaseChar() }

    val list = IntArray(26) { 0 }

    for (c in line) {
        list[c.code - 'a'.code] ++
    }

    var count = Integer.MIN_VALUE
    var answer: Char = '?'
    for (i in 0..<list.size) {
        if (count < list[i]) {
            count = list[i]
            answer = ('a'.code + i).toChar()
        } else if (count == list[i]) {
            answer = '?'
        }
    }

    print( if (answer != '?') answer.uppercase() else "?" )
}
