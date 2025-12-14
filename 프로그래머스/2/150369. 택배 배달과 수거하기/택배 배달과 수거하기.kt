class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var size = deliveries.size - 1
        var remainDeliveriesSum = deliveries.sum()
        var remainPickupsSum = pickups.sum()
        
        while (remainDeliveriesSum > 0 || remainPickupsSum > 0) {
            for (i in size downTo 0) {
                if (deliveries[i] != 0 || pickups[i] != 0) {
                    size = i
                    break
                }
            } // 가장 멀리 가야하는 인덱스 찾기
            
            answer += (size+1) * 2 // 한번 왕복

            var remain = cap
            for (i in size downTo 0) {
                if (remain == 0) break
                val deliver = if (deliveries[i] < remain) deliveries[i] else remain
                deliveries[i] -= deliver
                remain -= deliver
                remainDeliveriesSum -= deliver
            }
            
            var remain2 = cap
            for (i in size downTo 0) {
                if (remain2 == 0) break
                val recycle = if (pickups[i] < remain2) pickups[i] else remain2
                pickups[i] -= recycle
                remain2 -= recycle
                remainPickupsSum -= recycle
            }
            
        }
        
        return answer
    }
}