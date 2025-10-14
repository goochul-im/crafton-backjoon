import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

//  화살표 미로 (Normal)

fun main(args: Array<String>) {

    var answer = "NO"
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ROW, COL, K) = br.readLine().split(" ").map { it.toInt() }

    val prob = Array(ROW) { br.readLine() }
    val isVisited = Array(ROW) { Array(COL) { Array(K + 1) { BooleanArray(K + 1) } } }

    data class Point(val row: Int, val col: Int, val leftScroll: Int, val rightScroll: Int)

    fun bfs() : String {
        val q: Queue<Point> = LinkedList()
        q.add(Point(0, 0, K, K))
        isVisited[0][0][K][K] = true

        // 방향 배열과 맵핑 (상, 우, 하, 좌)
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val directions = mapOf('U' to 0, 'R' to 1, 'D' to 2, 'L' to 3)

        while (q.isNotEmpty()) {
            val (row, col, left, right) = q.poll()

            if (row == ROW - 1 && col == COL - 1) {
                return "Yes"
            }

            val currentDir = directions[prob[row][col]]!!
            // case 1 : 그대로
            val nextRow = row + dx[currentDir]
            val nextCol = col + dy[currentDir]

            if (nextRow in 0..<ROW && nextCol in 0..<COL && !isVisited[nextRow][nextCol][left][right]) {
                isVisited[nextRow][nextCol][left][right] = true
                q.add(Point(nextRow, nextCol, left, right))
            }

            // case 2 : 왼쪽 스크롤
            for (scroll in 1..3) {
                if (scroll > left) break

                val nextDir = ((currentDir - scroll) + 4) % 4
                val nextRow = row + dx[nextDir]
                val nextCol = col + dy[nextDir]
                val curScroll = left - scroll

                if (nextRow in 0..<ROW && nextCol in 0..<COL && !isVisited[nextRow][nextCol][curScroll][right]) {
                    isVisited[nextRow][nextCol][curScroll][right] = true
                    q.add(Point(nextRow, nextCol, curScroll, right))
                }
            }

            // case 3 : 오른쪽 스크롤
            for (scroll in 1..3) {
                if (scroll > right) break

                val nextDir = (currentDir + scroll) % 4
                val nextRow = row + dx[nextDir]
                val nextCol = col + dy[nextDir]
                val curScroll = right - scroll

                if (nextRow in 0..<ROW && nextCol in 0..<COL && !isVisited[nextRow][nextCol][left][curScroll]) {
                    isVisited[nextRow][nextCol][left][curScroll] = true
                    q.add(Point(nextRow, nextCol, left, curScroll))
                }

            }

        }
        return "No"
    }

    print(bfs())
}
