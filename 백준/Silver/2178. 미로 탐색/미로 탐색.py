# 2178 미로 탐색
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

maze = []
is_visited = [[False] * M for _ in range(N)]
for _ in range(N):
    maze.append(list(map(int, sys.stdin.readline().strip())))

moving = [[0, 1], [0, -1], [1, 0], [-1, 0]]

count = 0


def bfs():
    global count
    que = deque()
    is_visited[0][0] = True
    que.append((0, 0))
    while que:
        length = len(que)
        count += 1
        for i in range(length):
            pop = que.popleft()
            if pop == (N - 1, M - 1):
                return
            for move in moving:
                next_row = pop[0] + move[0]
                next_col = pop[1] + move[1]
                if N > next_row >= 0 and M > next_col >= 0 and not is_visited[next_row][next_col] and maze[next_row][next_col]:
                    is_visited[next_row][next_col] = True
                    que.append((next_row, next_col))


bfs()
print(count)
