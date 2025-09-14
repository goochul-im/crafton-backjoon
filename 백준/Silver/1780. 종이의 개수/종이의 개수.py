# 24060 종이의 개수
import sys

N = int(sys.stdin.readline())
paper = []
for _ in range(N):
    paper.append(list(map(int, sys.stdin.readline().split())))


def is_same_paper(row: int, col: int, length: int) -> bool:
    criteria = paper[row][col]
    for i in range(row, row + length):
        for j in range(col, col + length):
            if criteria != paper[i][j]:
                return False
    return True


count = [0, 0, 0]


def find(row: int, col: int, length: int):
    if length == 1 or is_same_paper(row, col, length):
        count[paper[row][col] + 1] += 1
        return

    next_length = length // 3
    for i in range(3):
        for j in range(3):
            find(row + next_length * i, col + next_length * j, next_length)


find(0, 0, N)

for c in count:
    print(c)
