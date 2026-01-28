class Solution {
    fun solution(n: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        dp[0] = 0
        dp[1] = 1
        
        for (i in 2 until n + 1) {
            dp[i] = (dp[i-1] % 1234567 + dp[i-2] % 1234567) % 1234567
        }
        
        
        return dp[n]
    }
}