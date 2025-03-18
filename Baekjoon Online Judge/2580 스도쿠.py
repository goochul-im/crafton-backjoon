# 2580 스도쿠
# pypy로 해야 시간초과가 안남...
import sys

sudoku = []
for i in range(9):
    sudoku.append(list(map(int, sys.stdin.readline().split())))


def get_correct_numbers(row, col):
    empty_number_list = [False] * 10
    empty_number_list[0] = True

    for s in range(9):
        if sudoku[row][s] != 0:
            empty_number_list[sudoku[row][s]] = True
        if sudoku[s][col] != 0:
            empty_number_list[sudoku[s][col]] = True

    find_row = (row // 3) * 3
    find_col = (col // 3) * 3

    for k in range(find_row, find_row + 3):
        for l in range(find_col, find_col + 3):
            if sudoku[k][l] != 0:
                empty_number_list[sudoku[k][l]] = True

    return [idx for idx, val in enumerate(empty_number_list) if val is False]


empty_cell = []

for i in range(9):
    for j in range(9):
        if sudoku[i][j] == 0:
            empty_cell.append((i, j))


def print_sudoku():
    for su in sudoku:
        print(" ".join(map(str, su)))


def find(idx):
    if idx == len(empty_cell):
        print_sudoku()
        sys.exit(0)

    row, col = empty_cell[idx]
    nominee_number_list = get_correct_numbers(row, col)

    for n in nominee_number_list:
        sudoku[row][col] = n
        find(idx + 1)
        sudoku[row][col] = 0


find(0)
