# 15651 N과 M(3)
import sys

N, M = map(int, sys.stdin.readline().split())


def permutaion(idx: int, temp_lst: list):
    if len(temp_lst) == M:
        print(" ".join(map(str, temp_lst)))
        return

    for i in range(1, N + 1):
        temp_lst.append(i)
        permutaion(idx, temp_lst)
        temp_lst.pop()


permutaion(1, [])
