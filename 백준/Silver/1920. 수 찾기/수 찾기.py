# 1920 수 찾기
import sys

N = int(sys.stdin.readline())
prob = sorted(list(map(int, sys.stdin.readline().split())))
M = int(sys.stdin.readline())
ans = list(map(int, sys.stdin.readline().split()))


def binary_search(answer_num: int):
    left = 0
    right = N - 1
    while left <= right:
        middle = (left + right) // 2
        if prob[middle] == answer_num:
            print(1)
            return
        elif answer_num < prob[middle]:
            right = middle - 1
        else:
            left = middle + 1
    print(0)


for a in ans:
    binary_search(a)
