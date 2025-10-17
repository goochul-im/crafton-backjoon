import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays

//  균형잡힌 세상

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var all = br.readText().split(".")
    all = all.slice(0..<all.size - 2)


    for (line in all) {
        val stack = ArrayDeque<Char>()
        stack.add('S')
//        println("line : $line")

        for (c in line.toCharArray()) {
            when (c){
                '(' -> stack.addLast(c)
                ')' -> {
                    if (stack.last() == '(') stack.removeLast()
                    else stack.addLast(c)
                }
                '[' -> stack.addLast(c)
                ']' -> {
                    if (stack.last() == '[') stack.removeLast()
                    else stack.addLast(c)
                }
            }
        }

        if (stack.size == 1) println("yes")
        else println("no")
    }

}
