class Solution {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        var answer: Int = 0
        
        val rowSize = storage.size + 2
        val colSize = storage[0].length + 2
        
        val empty = '.'
        
        val map : Array<MutableList<Char>> = Array(rowSize) { mutableListOf<Char>() }
        map[0] = MutableList<Char>(colSize) { empty }
        map[rowSize - 1] = MutableList<Char>(colSize) { empty }
        
        for (i in 1 .. rowSize - 2) {
            val list = storage[i - 1].toMutableList()
            list.add(0,empty)
            list.add(empty)
            map[i] = list
        }
        
        val move = arrayOf(
            Pair(-1,0),
            Pair(1,0),
            Pair(0,-1),
            Pair(0,1),
        )
        
        val clear = mutableSetOf<Pair<Int,Int>>()
        
        fun bfs(find: Char) {
            val isVisited = Array(rowSize) { BooleanArray(colSize) {false} }
            val Q = ArrayDeque<Pair<Int,Int>>()
            Q.addLast(Pair(0,0))
            isVisited[0][0] = true
            
            while(Q.isNotEmpty()){
                
                val size = Q.size
                for (i in 0 until size) {
                    
                    val (row, col) = Q.removeFirst()
                    if (map[row][col] == find) {
                        clear.add(Pair(row,col)) 
                        continue
                    }
                    else if (map[row][col] != empty) continue
                    
                    for ( m in move) {
                        val (r, c) = m
                        val nextRow = row + r
                        val nextCol = col + c
                        
                        if (nextRow in 0 until rowSize && 
                                nextCol in 0 until colSize && 
                                !isVisited[nextRow][nextCol]) {
                            isVisited[nextRow][nextCol] = true
                            Q.addLast(Pair(nextRow, nextCol))
                        }
                    }
                }
            }
        }
        
        for (req in requests) {
            if (req.length == 1) {
                bfs(req[0])
            } else {
                for (r in 1 until rowSize) {
                    for (c in 1 until colSize){
                        if (map[r][c] == req[0]) {
                            clear.add(Pair(r,c))
                        }
                    }
                }
            }
            
            for (c in clear) {
                val (row, col) = c
                map[row][col] = empty
            }
            
            clear.clear()
        }
        
        // for (m in map) {
        //     println(m)
        // }
        
        for (r in 1 until rowSize) {
            for (c in 1 until colSize) {
                if (map[r][c] != empty) answer++
            }
        }
        
        return answer
    }
}