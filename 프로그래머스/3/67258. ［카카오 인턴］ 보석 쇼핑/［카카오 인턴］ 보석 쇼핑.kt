class Solution {
    fun solution(gems: Array<String>): IntArray {
        
        val gemsSize = gems.toSet().size
        var left = 0
        var right = 0
        val map = mutableMapOf<String, Int>()
        var minLength = Int.MAX_VALUE
        var answerLeft = 0
        var answerRight = 0
        
        while (right < gems.size || (right == gems.size && map.size == gemsSize)) {
            
            if (map.size < gemsSize) { // 보석을 추가해야하는경우
                val addTarget = gems[right]
                map[addTarget] = map.getOrDefault(addTarget, 0) + 1
                right++
            } else { // 보석을 모두 가진 경우
                val nowLength = (right - left + 1)
                if (minLength > nowLength) {
                    minLength = nowLength
                    answerLeft = left
                    answerRight = right
                }
                val deleteTarget = gems[left]
                map.computeIfPresent(deleteTarget) { key, value ->
                    if (value == 1) null
                    else value -1
                }
                left++
            }
            
            
        }
        
        return intArrayOf(answerLeft + 1, answerRight)
    }
}