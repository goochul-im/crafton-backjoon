import java.io.BufferedReader
import java.io.InputStreamReader

var answer = 0
var N = 0

// 1. 컬럼 사용 여부 체크
lateinit var columns: BooleanArray

// 2. 우상향 대각선 (row + col)
// (0,0) -> 0, (N-1, N-1) -> 2N-2. 총 2N-1 크기 필요
lateinit var diagonal_1: BooleanArray 

// 3. 우하향 대각선 (row - col)
// (N-1, 0) -> N-1, (0, N-1) -> -(N-1).
// 인덱스는 음수가 될 수 없으므로 N-1을 더해준다.
// (row - col + N - 1)
// [0 ~ 2N-2] 범위. 총 2N-1 크기 필요
lateinit var diagonal_2: BooleanArray

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    columns = BooleanArray(N)
    diagonal_1 = BooleanArray(2 * N - 1)
    diagonal_2 = BooleanArray(2 * N - 1)

    dfs(0)
    println(answer)
}

fun dfs(row: Int) {
    if (row == N) {
        answer++
        return
    }

    for (col in 0..<N) {
        // 3가지 조건 동시 체크
        if (columns[col] || diagonal_1[row + col] || diagonal_2[row - col + N - 1]) {
            continue
        }

        // 퀸 배치
        columns[col] = true
        diagonal_1[row + col] = true
        diagonal_2[row - col + N - 1] = true

        dfs(row + 1)

        // 백트래킹 (배치 해제)
        columns[col] = false
        diagonal_1[row + col] = false
        diagonal_2[row - col + N - 1] = false
    }
}