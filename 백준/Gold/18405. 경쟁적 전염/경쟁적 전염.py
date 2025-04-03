# 18405 경쟁적 전염
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
prob = []
for _ in range(N):
    prob.append(list(map(int, sys.stdin.readline().split())))

S, X, Y = map(int, sys.stdin.readline().split())

moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def bfs():
    Q = deque()
    for i in range(N):
        for j in range(N):
            if prob[i][j]:
                Q.append((prob[i][j], i, j))
    Q = deque(sorted(Q, key=lambda x: x[0]))
    count = -1

    while Q:
        count += 1
        if count == S:
            return
        length = len(Q)
        for _ in range(length):
            num, row, col = Q.popleft()
            for move in moving:
                next_row = row + move[0]
                next_col = col + move[1]
                if N > next_row >= 0 and N > next_col >= 0 and prob[next_row][next_col] == 0:
                    prob[next_row][next_col] = num
                    Q.append((num, next_row, next_col))


bfs()
print(prob[X - 1][Y - 1])
