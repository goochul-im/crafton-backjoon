# 1303 전쟁 - 전투
import sys

INPUT = sys.stdin.readline
N, M = map(int, INPUT().split())

is_visited = [[False] * N for _ in range(M)]
prob = []

for _ in range(M):
    prob.append(list(INPUT().strip()))

W_power = 0
B_power = 0

moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def dfs(word, row, col):
    count = 1
    for move in moving:
        next_row = row + move[0]
        next_col = col + move[1]
        if (M > next_row >= 0 and N > next_col >= 0 and
                not is_visited[next_row][next_col] and prob[next_row][next_col] == word):
            is_visited[next_row][next_col] = True
            count += dfs(word, next_row, next_col)
    return count


for i in range(M):
    for j in range(N):
        if not is_visited[i][j]:
            is_visited[i][j] = True
            if prob[i][j] == 'W':
                W_power += dfs(prob[i][j], i, j) ** 2
            else:
                B_power += dfs(prob[i][j], i, j) ** 2

print(f"{W_power} {B_power}")
