# 2470 두 용액
import sys

N = int(sys.stdin.readline())

prob = sorted(list(map(int, sys.stdin.readline().split())))


def binary_search():
    now_answer = []
    min_value = float('inf')
    for i in range(N):
        left = i + 1
        right = N - 1
        middle = 0
        while left <= right:
            middle = (left + right) // 2
            if prob[middle] + prob[i] == 0:
                now_answer = sorted([prob[middle], prob[i]])
                print(" ".join(map(str, now_answer)))
                return
            elif prob[middle] + prob[i] < 0:
                left = middle + 1
            else:
                right = middle - 1

            if abs(min_value) > abs(prob[middle] + prob[i]):
                min_value = abs(prob[middle] + prob[i])
                now_answer = [prob[middle], prob[i]]

    now_answer = sorted(now_answer)
    print(" ".join(map(str, now_answer)))


binary_search()
