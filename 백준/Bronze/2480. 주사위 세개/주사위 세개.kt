import java.io.BufferedReader
import java.io.InputStreamReader

//  2480. 주사위 세개

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val prob = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    prob.sortDescending()
    val big = prob[0]
    val mid = prob[1]
    val small = prob[2]
    if (big == mid && mid == small) {
        print(10000 + big * 1000)
    } else if (big == mid) {
        print(1000 + mid * 100)
    } else if (mid == small) {
        print(1000 + mid * 100)
    } else{
        print(big * 100)
    }

}
