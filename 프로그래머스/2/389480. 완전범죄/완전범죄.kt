class Solution {
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        var answer: Int = Int.MAX_VALUE
        
        val dp = Array(m) {0}
        val allA = info.sumOf { it[0] }
        
        for ((A, B) in info) {
            for (j in m-1 downTo B) {
                dp[j] = Math.max(dp[j], dp[j - B] + A)
            }
        }

        val minimum = dp.maxOrNull() ?: 0
        
        answer = allA - minimum
        
        return if (answer < n) answer else -1
    }
}