import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ROW, COL, K) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(ROW) { br.readLine() }
    
    val isVisited = Array(ROW) { Array(COL) { Array(K + 1) { BooleanArray(K + 1) } } }
    data class Point(val row: Int, val col: Int, val left: Int, val right: Int)

    // BFS 함수를 main 함수 밖으로 빼거나, 아래 변수들을 bfs 내부로 옮겨야 합니다.
    // 여기서는 bfs 내부로 옮기는 것으로 수정합니다.
    fun bfs(): String {
        val q: Queue<Point> = LinkedList()
        q.add(Point(0, 0, K, K))
        isVisited[0][0][K][K] = true

        val dx = intArrayOf(-1, 0, 1, 0) // 상, 우, 하, 좌
        val dy = intArrayOf(0, 1, 0, -1)
        val directions = mapOf('U' to 0, 'R' to 1, 'D' to 2, 'L' to 3)

        while (q.isNotEmpty()) {
            val (row, col, left, right) = q.poll()

            if (row == ROW - 1 && col == COL - 1) {
                return "Yes"
            }

            val currentDir = directions[map[row][col]]!!

            // Case 1: 스크롤 미사용 (직진)
            val nextRow0 = row + dx[currentDir]
            val nextCol0 = col + dy[currentDir]
            if (nextRow0 in 0..<ROW && nextCol0 in 0..<COL && !isVisited[nextRow0][nextCol0][left][right]) {
                isVisited[nextRow0][nextCol0][left][right] = true
                q.add(Point(nextRow0, nextCol0, left, right))
            }

            // Case 2: 오른쪽 스크롤 사용 (1~3개)
            var nextRightDir = currentDir
            for (i in 1..3) {
                if (right < i) break // 사용할 스크롤이 부족하면 중단
                
                nextRightDir = (nextRightDir + 1) % 4 // 90도씩 회전
                val nextRow = row + dx[nextRightDir]
                val nextCol = col + dy[nextRightDir]
                val nextRight = right - i

                if (nextRow in 0..<ROW && nextCol in 0..<COL && !isVisited[nextRow][nextCol][left][nextRight]) {
                    isVisited[nextRow][nextCol][left][nextRight] = true
                    q.add(Point(nextRow, nextCol, left, nextRight))
                }
            }

            // Case 3: 왼쪽 스크롤 사용 (1~3개)
            var nextLeftDir = currentDir
            for (i in 1..3) {
                if (left < i) break // 사용할 스크롤이 부족하면 중단
                
                nextLeftDir = (nextLeftDir - 1 + 4) % 4 // 90도씩 회전
                val nextRow = row + dx[nextLeftDir]
                val nextCol = col + dy[nextLeftDir]
                val nextLeft = left - i
                
                if (nextRow in 0..<ROW && nextCol in 0..<COL && !isVisited[nextRow][nextCol][nextLeft][right]) {
                    isVisited[nextRow][nextCol][nextLeft][right] = true
                    q.add(Point(nextRow, nextCol, nextLeft, right))
                }
            }
        }
        return "No"
    }

    print(bfs())
}