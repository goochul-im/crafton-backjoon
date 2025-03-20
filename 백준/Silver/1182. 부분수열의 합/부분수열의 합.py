# 1182 부분수열의 합
import sys

N, S = map(int, sys.stdin.readline().split())
prob = list(map(int, sys.stdin.readline().split()))
COUNT = 0


def find(cur_sum: int, idx: int):
    global COUNT
    if cur_sum == S and idx != 0:
        COUNT += 1

    for i in range(N):
        next_idx = idx + i
        if next_idx < N:
            find(cur_sum + prob[next_idx], next_idx + 1)
        else:
            break


find(0, 0)
print(COUNT)
