class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = Int.MAX_VALUE
        
        val goal = queue1.sum() + queue2.sum()
        val q1 = ArrayDeque(queue1.map { it.toLong() })
        val q2 = ArrayDeque(queue2.map { it.toLong() })
        
        var q1sum = q1.sum()
        var q2sum = q2.sum()
        
        val maxMoves = (q1.size + q2.size) * 4
        var moves = 0
        
        while (maxMoves > moves) {
            if (q1sum == q2sum) {
                answer = moves
                break
            }
            
            if (q1sum > q2sum) {
                val poll = q1.removeFirst()
                q1sum -= poll
                q2sum += poll
                q2.addLast(poll)
            } else {
                //q2에서 빼서 q1에 더하기
                val poll = q2.removeFirst()
                q2sum -= poll
                q1sum += poll
                q1.addLast(poll)
            }
            
            moves++
        }
        
        return if (answer!=Int.MAX_VALUE) answer else -1
    }
}