import java.io.BufferedReader
import java.io.InputStreamReader

//  대칭 차집합

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val aSet = mutableSetOf<Int>()
    var line = br.readLine().split(" ").map { it.toInt() }
    line.forEach {
        aSet.add(it)
    }
    line = br.readLine().split(" ").map { it.toInt() }
    val bSet = mutableSetOf<Int>()
    line.forEach {
        bSet.add(it)
    }

    val Cset = aSet subtract bSet
    val Dset = bSet subtract aSet
    val set = Cset union Dset
    println(set.size)

}
