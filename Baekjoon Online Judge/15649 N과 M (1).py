# 15649 N과 M
import sys

N, M = map(int, sys.stdin.readline().split())


def permutation(n, m, lst: list):
    if len(lst) == m:
        print(" ".join(map(str, lst)))
        return

    for i in range(n):
        if i + 1 in lst:
            continue
        lst.append(i + 1)
        permutation(n, m, lst)
        lst.remove(i + 1)


permutation(N, M, [])
