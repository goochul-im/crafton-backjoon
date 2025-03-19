# 15657 N과 M(8)
import sys

N, M = map(int, sys.stdin.readline().split())

prob = sorted(list(map(int, sys.stdin.readline().split())))


def recursion(idx: int, temp_list: list):
    if len(temp_list) == M:
        print(" ".join(map(str, temp_list)))
        return
    for i in range(idx, N):
        temp_list.append(prob[i])
        recursion(i, temp_list)
        temp_list.pop()


recursion(0, [])
