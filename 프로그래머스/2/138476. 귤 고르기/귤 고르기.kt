class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var remain = k
        
        val counts = tangerine.groupBy { it }
            .map {it.value.size}
            .sortedDescending()
            
        for (count in counts) {
            answer++
            remain -= count
            if( remain <= 0) break
        }
        
        return answer
    }
}