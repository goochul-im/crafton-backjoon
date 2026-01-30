class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1
 
        var big = Math.max(a, b)
        var small = Math.min(a, b)
        
        while ((small % 2 != 1) || (small + 1 != big)) {
            big = if (big % 2 == 1) big + 1 else big
            small = if (small % 2 == 1) small + 1 else small
            
            big /= 2
            small /= 2
            
            answer++
        }

        return answer
    }
}