# 2573 빙산
import sys

sys.setrecursionlimit(300000)
N, M = map(int, sys.stdin.readline().split())

iceberg = []
is_visited = []

for _ in range(N):
    iceberg.append(list(map(int, sys.stdin.readline().split())))

moving = [[0, 1], [0, -1], [1, 0], [-1, 0]]  # 동서남북


def dfs(row, col):
    next_height = get_next_height(row, col)
    for move in moving:
        next_row = row + move[0]
        next_col = col + move[1]
        if N > next_row >= 0 and M > next_col >= 0 and iceberg[next_row][next_col] > 0 and not is_visited[next_row][
            next_col]:
            is_visited[next_row][next_col] = True
            dfs(next_row, next_col)
    iceberg[row][col] = next_height


def get_next_height(row, col):
    count = 0
    cur_height = iceberg[row][col]
    for move in moving:
        next_row = row + move[0]
        next_col = col + move[1]
        if N > next_row >= 0 and M > next_col >= 0 and iceberg[next_row][next_col] == 0:
            count += 1

    return max(0, cur_height - count)


COUNT = -1


def execute():
    global is_visited, COUNT
    while True:
        COUNT += 1
        flag = False
        is_visited = [[False] * M for _ in range(N)]
        for i in range(N):
            for j in range(M):
                if iceberg[i][j] > 0 and not is_visited[i][j]:
                    if flag:
                        print(COUNT)
                        return
                    flag = True
                    is_visited[i][j] = True
                    dfs(i, j)
        if not flag:
            break
    print(0)


execute()
