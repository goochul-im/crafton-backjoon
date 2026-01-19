class Solution {
    fun solution(s: String): IntArray {
        var cur = s
        var countNum = 0
        var count = 0
        
        while (cur != "1") {
            countNum ++
            
            val zero = cur.count { it == '0' }
            count += zero
            val nextLength = cur.length - zero
            cur = nextLength.toString(2)
            
        }
        
        return intArrayOf(countNum, count)
    }
}