# 10815 숫자 카드
import sys

N = int(sys.stdin.readline())

card = sorted(list(map(int, sys.stdin.readline().split())))

M = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.readline().split()))

ans = []


def binary_search(num: int):
    left = 0
    right = N - 1
    while left <= right:
        middle = (left + right) // 2
        if card[middle] == num:
            ans.append(1)
            return
        elif num < card[middle]:
            right = middle - 1
        else:
            left = middle + 1
    ans.append(0)


for p in prob:
    binary_search(p)
print(*ans)
