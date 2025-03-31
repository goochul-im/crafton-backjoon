# 2667 단지 번호 붙이기
import sys

N = int(sys.stdin.readline())

prob = []
is_visited = [[False] * N for _ in range(N)]
for _ in range(N):
    prob.append(list(map(int, sys.stdin.readline().strip())))

HOUSE = 0
COUNT = 0
ans = []
moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def dfs(row, col):
    global COUNT
    COUNT += 1
    for move in moving:
        next_row = row + move[0]
        next_col = col + move[1]
        if N > next_row >= 0 and N > next_col >= 0 and not is_visited[next_row][next_col] and prob[next_row][next_col]:
            is_visited[next_row][next_col] = True
            dfs(next_row, next_col)


def execute():
    global HOUSE, COUNT
    for i in range(N):
        for j in range(N):
            if prob[i][j] and not is_visited[i][j]:
                is_visited[i][j] = True
                HOUSE += 1
                COUNT = 0
                dfs(i, j)
                ans.append(COUNT)


execute()
print(HOUSE)
for a in sorted(ans):
    print(a)
