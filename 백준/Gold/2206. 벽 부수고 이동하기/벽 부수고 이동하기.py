# 2206 벽 부수고 이동하기
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

maze = []

for _ in range(N):
    maze.append(list(map(int, sys.stdin.readline().strip())))

is_visited = [[False] * M for _ in range(N)]
is_visited_wall = [[False] * M for _ in range(N)]

moving = [[1, 0], [-1, 0], [0, -1], [0, 1]]


def bfs():
    Q = deque()
    Q.append((0, 0, 0))
    is_visited[0][0] = True
    is_visited_wall[0][0] = True

    count = 0
    while Q:
        length = len(Q)
        count += 1
        for _ in range(length):
            row, col, wall = Q.popleft()
            if row == N - 1 and col == M - 1:
                print(count)
                return
            for move in moving:
                next_row = row + move[0]
                next_col = col + move[1]
                if wall: # 이미 벽을 통과한 상태라면
                    if N > next_row >= 0 and M > next_col >= 0:
                        if maze[next_row][next_col] == 0 and not is_visited[next_row][next_col] and not \
                                is_visited_wall[next_row][next_col]:
                            is_visited_wall[next_row][next_col] = True
                            Q.append((next_row, next_col, wall))
                else:
                    if N > next_row >= 0 and M > next_col >= 0:
                        if maze[next_row][next_col] == 0 and not is_visited[next_row][next_col]:
                            is_visited[next_row][next_col] = True
                            is_visited_wall[next_row][next_col] = True
                            Q.append((next_row, next_col, wall))
                        elif maze[next_row][next_col] == 1 and not is_visited[next_row][next_col]:
                            is_visited[next_row][next_col] = True
                            is_visited_wall[next_row][next_col] = True
                            Q.append((next_row, next_col, wall + 1))

    print(-1)


bfs()
