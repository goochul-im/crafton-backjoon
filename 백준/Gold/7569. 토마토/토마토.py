# 7569 토마토
import sys
from collections import deque

M, N, H = map(int, sys.stdin.readline().split())

box = [[[] for _ in range(N)] for _ in range(H)]

for i in range(H):
    for j in range(N):
        temp = list(map(int, sys.stdin.readline().split()))
        for k in range(M):
            box[i][j].append(temp[k])

moving = [[1, 0, 0], [-1, 0, 0], [0, 0, -1], [0, 0, 1], [0, 1, 0], [0, -1, 0]]  # 위,아래,왼쪽,오른쪽,앞,뒤


def bfs():
    count = 0
    Q = deque()
    for height in range(H):
        for row in range(N):
            for col in range(M):
                if box[height][row][col] == 1:
                    Q.append((height, row, col))

    while Q:
        length = len(Q)
        flag = False
        for _ in range(length):
            height, row, col = Q.popleft()
            for move in moving:
                next_height = height + move[0]
                next_row = row + move[1]
                next_col = col + move[2]
                if (H > next_height >= 0 and N > next_row >= 0 and M > next_col >= 0
                        and box[next_height][next_row][next_col] == 0):
                    box[next_height][next_row][next_col] = 1
                    Q.append((next_height, next_row, next_col))
                    flag = True
        if flag:
            count += 1

    for height in range(H):
        for row in range(N):
            for col in range(M):
                if box[height][row][col] == 0:
                    print(-1)
                    return
    print(count)


bfs()
