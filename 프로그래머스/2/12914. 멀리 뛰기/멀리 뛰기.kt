class Solution {
    fun solution(n: Int): Long {
        if (n == 1) return 1
        if (n == 2) return 2
        
        val dp = LongArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        
        for (i in 3..n) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567
        }
        
        return dp[n]
    }
}