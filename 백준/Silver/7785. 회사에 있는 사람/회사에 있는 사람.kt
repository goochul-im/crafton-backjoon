import java.io.BufferedReader
import java.io.InputStreamReader

//  회사에 있는 사람

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N:Int = br.readLine().toInt()

    val set = mutableSetOf<String>()

    for (i in 0..<N) {
        val (name, status) = br.readLine().split(" ")

        when (status) {
            "enter" -> set.add(name)
            else -> set.remove(name)
        }

    }

    val list = mutableListOf<String>()
    set.toCollection(list)
    list.sortDescending()

    list.forEach {
        println(it)
    }
}
