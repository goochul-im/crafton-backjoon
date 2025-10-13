import java.io.BufferedReader
import java.io.InputStreamReader

//  A×B

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (X, Y) = br.readLine().split(" ").map { it.toInt() }
    print(X * Y)
}
