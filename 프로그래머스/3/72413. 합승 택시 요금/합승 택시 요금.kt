import java.util.*

class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        
        data class Node(val node:Int, val cost: Int)
        
        val graph = Array(n + 1) { mutableListOf<Node>() }
        
        for (f in fares) {
            val (start, end, cost) = f
            graph[start].add(Node(end, cost))
            graph[end].add(Node(start, cost))
        }
        
        fun dijkstra(start:Int) : IntArray {
            val Q = PriorityQueue<Node>(compareBy {it.cost})
            val distance = IntArray(n+1) {Int.MAX_VALUE}
            distance[start] = 0
            Q.add(Node(start, 0))
            
            while(Q.isNotEmpty()) {
                
                val (curNode, curCost) = Q.poll()
                
                if (distance[curNode] < curCost) continue
                
                for ((nextNode, nextCost) in graph[curNode]) {
                    val newCost = curCost + nextCost
                    
                    if (newCost < distance[nextNode]) {
                        distance[nextNode] = newCost
                        Q.add(Node(nextNode, newCost))
                    }
                }
            }
            return distance
        }
        
        val S_distance = dijkstra(s)
        val A_distance = dijkstra(a)
        val B_distance = dijkstra(b)
        
        for (i in 1..n) {
            answer = Math.min(S_distance[i] + A_distance[i] + B_distance[i], answer)
        }
        
        return answer
    }
}