import sys
from collections import deque

T = int(sys.stdin.readline())

moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def bfs(row, col, is_visited, prob):
    Q = deque()
    Q.append((row, col))

    while Q:
        cur_row, cur_col = Q.popleft()
        for move_row, move_col in moving:
            next_row = cur_row + move_row
            next_col = cur_col + move_col

            if next_row >= 0 and next_row < N and next_col >= 0 and next_col < M and is_visited[next_row][next_col] == False and prob[next_row][next_col] == 1:
                is_visited[next_row][next_col] = True
                Q.append((next_row, next_col))


for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    prob = [[0] * M for _ in range(N)]
    is_visited = [[False] * M for _ in range(N)]
    for _ in range(K):
        col, row = map(int, sys.stdin.readline().split())
        prob[row][col] = 1
    count = 0

    for i in range(N):
        for j in range(M):
            if prob[i][j] == 1 and is_visited[i][j] == False:
                count += 1
                is_visited[i][j] = True
                bfs(i, j, is_visited, prob)

    print(count)
