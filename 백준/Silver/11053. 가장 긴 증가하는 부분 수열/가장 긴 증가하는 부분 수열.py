# 11053 가장 긴 증가하는 부분수열
import sys

N = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.readline().split()))
ans = [prob[0]]


def binary_search(number: int):
    left = 0
    right = len(ans) - 1
    while left <= right:
        middle = (left + right) // 2
        if number > ans[middle]:
            left = middle + 1
        else:
            right = middle - 1
    return left


def find():
    for i in range(1, N):
        criteria = ans[-1]
        if prob[i] > criteria:
            ans.append(prob[i])
        else:
            idx = binary_search(prob[i])
            ans[idx] = prob[i]
    print(len(ans))


find()
