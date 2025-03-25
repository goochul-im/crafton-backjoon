# 1992 쿼드트리
import sys

N = int(sys.stdin.readline())

prob = []
for _ in range(N):
    temp = sys.stdin.readline().strip()
    prob.append([int(x) for x in temp])


def is_same_area(row, col, length, lst: list) -> int:
    criteria = lst[row][col]
    for i in range(length):
        for j in range(length):
            if lst[row + i][col + j] != criteria:
                return False
    return True


def find(row, col, length, lst: list):
    message = ""

    criteria = lst[row][col]
    if length == 1:
        return str(criteria)
    if is_same_area(row, col, length, lst):
        return str(criteria)
    else:
        next_length = length // 2
        message += "("
        message += find(row, col, next_length, lst)
        message += find(row, col + next_length, next_length, lst)
        message += find(row + next_length, col, next_length, lst)
        message += find(row + next_length, col + next_length, next_length, lst)
        message += ")"
    return message


print(find(0, 0, N, prob))
