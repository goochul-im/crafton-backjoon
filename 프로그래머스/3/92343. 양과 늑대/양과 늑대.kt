class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        var answer: Int = 0
        
        val graph = Array(info.size) { mutableListOf<Int>() }
        for (e in edges) {
            val (start, end) = e
            graph[start].add(end)
        }
        
        // for (g in graph) {
        //     println(g)
        // }
        
        fun dfs(cur: Int, sheep: Int, wolf: Int, nextable: MutableSet<Int>) {
            if (sheep <= wolf) return
            
            answer = Math.max(answer, sheep)
            
            if (nextable.isEmpty()) return
            
            for (node in nextable) {
                
                val newNextable = nextable.toMutableSet()
                newNextable.remove(node)
                
                for (child in graph[node]) {
                    newNextable.add(child)
                }
                
                val nextSheep = if (info[node] == 0) 1 else 0
                val nextWolf = if (info[node] == 1) 1 else 0
                
                dfs(node, sheep + nextSheep, wolf + nextWolf, newNextable)
            }
        }
        
        val initialNextable = mutableSetOf<Int>()
        
        for (i in graph[0]) {
            initialNextable.add(i)
        }
        
        dfs(0,1,0, initialNextable)
        
        return answer
    }
}