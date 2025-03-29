# 3055 탈출
import sys
from collections import deque

R, C = map(int, sys.stdin.readline().split())

board = []
for _ in range(R):
    board.append(list(sys.stdin.readline().strip()))

is_visited = [[False] * C for _ in range(R)]

moving = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def bfs():
    water_Q = deque()
    player_Q = deque()

    for i in range(R):
        for j in range(C):
            if board[i][j] == 'S':
                player_Q.append((i, j))
                is_visited[i][j] = True
            elif board[i][j] == '*':
                water_Q.append((i, j))

    count = -1
    while player_Q:
        count += 1
        water_length = len(water_Q)
        for _ in range(water_length):
            row, col = water_Q.popleft()
            for move in moving:
                next_row = row + move[0]
                next_col = col + move[1]
                if R > next_row >= 0 and C > next_col >= 0 and board[next_row][next_col] == '.':
                    board[next_row][next_col] = "*"
                    water_Q.append((next_row, next_col))
        player_length = len(player_Q)
        for _ in range(player_length):
            row, col = player_Q.popleft()
            if board[row][col] == 'D':
                print(count)
                return
            for move in moving:
                next_row = row + move[0]
                next_col = col + move[1]
                if (R > next_row >= 0 and C > next_col >= 0 and not is_visited[next_row][next_col]
                        and (board[next_row][next_col] == '.' or board[next_row][next_col] == 'D')):
                    is_visited[next_row][next_col] = True
                    player_Q.append((next_row, next_col))

    print("KAKTUS")


bfs()
