class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        
        fun dfs(inChar: Int, outChar: Int) {
            if (outChar > inChar) return
            if (inChar > n || outChar > n) return
            if (inChar + outChar == n*2) {
                answer++
                return
            }
            
            dfs(inChar + 1, outChar)
            dfs(inChar, outChar + 1)
        }
        
        dfs(0,0)
        
        return answer
    }
}