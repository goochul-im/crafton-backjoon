# 15652 N과 M(4)
import sys

N, M = map(int, sys.stdin.readline().split())


def permutaion(idx: int, temp_lst: list):
    if len(temp_lst) == M:
        print(" ".join(map(str, temp_lst)))
        return

    for i in range(idx, N + 1):
        temp_lst.append(i)
        permutaion(i, temp_lst)
        temp_lst.remove(i)


permutaion(1, [])
