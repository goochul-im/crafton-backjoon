# 1388 바닥 장식
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

prob = []

for _ in range(N):
    prob.append(list(sys.stdin.readline().strip()))

is_visited = [[False] * M for _ in range(N)]
COUNT = 0

row_moving = [[0, -1], [0, 1]]
col_moving = [[1, 0], [-1, 0]]


def bfs_row(row, col):
    Q = deque()
    Q.append((row, col))

    while Q:
        row, col = Q.popleft()
        for move in row_moving:
            next_col = col + move[1]
            if M > next_col >= 0 and not is_visited[row][next_col] and prob[row][next_col] == '-':
                is_visited[row][next_col] = True
                Q.append((row, next_col))


def bfs_col(row, col):
    Q = deque()
    Q.append((row, col))

    while Q:
        row, col = Q.popleft()
        for move in col_moving:
            next_row = row + move[0]
            if N > next_row >= 0 and not is_visited[next_row][col] and prob[next_row][col] == '|':
                is_visited[next_row][col] = True
                Q.append((next_row, col))


for i in range(N):
    for j in range(M):
        if not is_visited[i][j]:
            is_visited[i][j] = True
            COUNT += 1
            if prob[i][j] == '-':
                bfs_row(i, j)
            else:
                bfs_col(i,j)

print(COUNT)
