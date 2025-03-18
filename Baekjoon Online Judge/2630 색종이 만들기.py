# 2630 색종이 만들기
import sys

N = int(sys.stdin.readline())

prob = []

for _ in range(N):
    prob.append(list(map(int, sys.stdin.readline().split())))

BLUE_COUNT = 0
WHITE_COUNT = 0


def is_all_same_color(row, col, length) -> bool:
    global BLUE_COUNT
    global WHITE_COUNT

    color = prob[row][col]

    for i in range(length):
        for j in range(length):
            if prob[row + i][col + j] != color:
                return False

    if color == 1:
        BLUE_COUNT += 1
    else:
        WHITE_COUNT += 1

    return True


def recursion(row, col, length):
    if is_all_same_color(row, col, length):
        return

    next_length = length // 2
    recursion(row, col, next_length)
    recursion(row, col + next_length, next_length)
    recursion(row + next_length, col, next_length)
    recursion(row + next_length, col + next_length, next_length)


recursion(0, 0, N)
print(WHITE_COUNT)
print(BLUE_COUNT)
