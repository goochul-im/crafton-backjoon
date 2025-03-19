# 1987 알파벳
import sys

R, C = map(int, sys.stdin.readline().split())
board = []
for _ in range(R):
    board.append(list(sys.stdin.readline()[:-1]))

COUNT = float('-inf')

moving = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # 상하좌우 이동


def find(cur_row, cur_col, cur_list: set):
    global COUNT
    COUNT = max(COUNT, len(cur_list))
    for i in range(4):
        next_row = cur_row + moving[i][0]
        next_col = cur_col + moving[i][1]
        if 0 <= next_row < R and 0 <= next_col < C and board[next_row][next_col] not in cur_list:
            cur_list.add(board[next_row][next_col])
            find(next_row, next_col, cur_list)
            cur_list.remove(board[next_row][next_col])


init_set = set()
init_set.add(board[0][0])
find(0, 0, init_set)
print(COUNT)
