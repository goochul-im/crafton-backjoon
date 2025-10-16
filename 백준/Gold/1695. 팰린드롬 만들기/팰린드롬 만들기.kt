import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

//  팰린드롬 만들기

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val prob = br.readLine().split(" ").map { it.toInt() }

    // i번째 인덱스부터 j번째 인덱스까지의 부분 수열에서 가장 긴 팰린드롬의 길이 = dp[i][j]
    val dp = Array(N) { IntArray(N) }

    for (i in 0..<N) { //길이가 1이면 팰린드롬
        dp[i][i] = 1
    }

    for (n in 2..N) { // 길이 2부터 N까지

        for (start in 0..N - n) { // 부분 수열의 시작 인덱스
            val end = start + n - 1// 부분 수열의 끝 인덱스

            if (prob[start] == prob[end]) {
                if (n == 2) dp[start][end] = 2
                else dp[start][end] = dp[start + 1][end - 1] + 2 //start와 end가 양 끝이니까 양 끝을 제외한 팰린드롬 + 2
            } else {
                dp[start][end] = max(dp[start + 1][end], dp[start][end - 1])
            }

        }

    }

    print(N - dp[0][N - 1])

}
