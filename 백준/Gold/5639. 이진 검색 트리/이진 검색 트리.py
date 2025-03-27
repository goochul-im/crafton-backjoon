# 5639 이진 검색 트리
import sys
sys.setrecursionlimit(300000)

prob = list(map(int, sys.stdin.read().split()))
ans = []


def get_postorder(lst: list):
    if not lst:
        return
    if len(lst) <= 1:
        print(lst[0])
        return
    root = lst[0]
    next_idx = 0
    for i in range(len(lst)):
        if lst[i] > root:
            next_idx = i
            break

    next_idx = len(lst) if next_idx == 0 else next_idx
    left = lst[1:next_idx]
    right = lst[next_idx:]
    get_postorder(left)
    get_postorder(right)
    print(root)


get_postorder(prob)
