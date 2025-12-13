class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        
        data class Server(val amount: Int, var remainTime: Int)
        
        val serverList = mutableListOf<Server>()
        
        for (p in players) {
            
            serverList.removeIf { it.remainTime == 0 }
            val activatedServerAmount = serverList.sumOf { it.amount }
            
            val minimum = p / m
            if (minimum > activatedServerAmount) {
                val needAmount = minimum - activatedServerAmount
                answer += needAmount
                serverList.add(Server(needAmount, k))
            }
            
            serverList.forEach { it.remainTime -= 1 }
        }
        
        
        return answer
    }
}