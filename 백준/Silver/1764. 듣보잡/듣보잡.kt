import java.io.BufferedReader
import java.io.InputStreamReader

//  듣보잡

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N,M) = br.readLine().split(" ").map { it.toInt() }

    val aSet = mutableSetOf<String>()
    val bSet = mutableSetOf<String>()

    for (i in 0 ..< N) {
        val name = br.readLine()
        aSet.add(name)
    }

    for (i in 0..<M) {
        val name = br.readLine()
        bSet.add(name)
    }

    val allList = mutableListOf<String>()
    val allSet = aSet intersect bSet
    allSet.toCollection(allList)
    allList.sort()

    println(allList.size)
    allList.forEach {
        if (aSet.contains(it) and bSet.contains(it)) {
            println(it)
        }
    }

}
