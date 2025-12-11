class Solution {
    fun solution(maps: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val row = maps.size
        val col = maps[0].length
        
        val move = arrayOf(
            arrayOf(-1,0),
            arrayOf(1,0),
            arrayOf(0,-1),
            arrayOf(0,1),
        )
        
        val isVisited = Array(row) { BooleanArray(col) { false } }
        
        fun bfs(sRow: Int, sCol: Int) : Int {
            val Q = ArrayDeque<Pair<Int, Int>>()
            Q.add(Pair(sRow, sCol))
            var count = 0
            
            while(Q.isNotEmpty()) {
                val size = Q.size
                
                for (i in 0 until size) {
                    val (cRow, cCol) = Q.removeFirst()
                    
                    count += maps[cRow][cCol].toInt() - '0'.code
                    // println("cur : ${maps[cRow][cCol]}, count : $count")
                    
                    for ((r, c) in move) {
                        val nextRow = r + cRow
                        val nextCol = c + cCol
                        
                        if (nextRow in 0 until row && nextCol in 0 until col 
                            && !isVisited[nextRow][nextCol] 
                            && maps[nextRow][nextCol] != 'X') {
                            
                            // println("nextRow : $nextRow, nextCol : $nextCol")
                            isVisited[nextRow][nextCol] = true
                            Q.addLast(Pair(nextRow, nextCol))
                            
                        }
                        
                    }
                    
                }
                
            }
            
            return count
        }
        
        for (r in 0 until row) {
            for (c in 0 until col){
                if (!isVisited[r][c] && maps[r][c] != 'X') {
                    // println("row : $r, col : $c")
                    isVisited[r][c] = true
                    val num = bfs(r,c)
                    answer.add(num)
                }
            }
        }
        
        if (answer.isEmpty()) answer.add(-1)
        
        return answer.sorted().toIntArray()
    }
}