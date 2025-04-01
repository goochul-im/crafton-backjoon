# 10026 적록색약
import sys

N = int(sys.stdin.readline())
sys.setrecursionlimit(300000)


prob = []
for _ in range(N):
    prob.append(list(sys.stdin.readline().strip()))

blind_count = 0
count = 0

moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]

is_visited = [[False] * N for _ in range(N)]


def dfs(color: list, row, col):
    for move in moving:
        next_row = row + move[0]
        next_col = col + move[1]
        if (N > next_row >= 0 and N > next_col >= 0 and not is_visited[next_row][next_col]
                and prob[next_row][next_col] in color):
            is_visited[next_row][next_col] = True
            dfs(color, next_row, next_col)


def execute():
    global count, is_visited, blind_count
    for i in range(N):
        for j in range(N):
            if not is_visited[i][j]:
                is_visited[i][j] = True
                if prob[i][j] == 'R':
                    dfs(['R'], i, j)
                elif prob[i][j] == 'G':
                    dfs(['G'], i, j)
                else:
                    dfs(['B'], i, j)
                count += 1
    is_visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not is_visited[i][j]:
                is_visited[i][j] = True
                if prob[i][j] == 'B':
                    dfs(['B'], i, j)
                else:
                    dfs(['R', 'G'], i, j)
                blind_count += 1


execute()
print(f"{count} {blind_count}")

