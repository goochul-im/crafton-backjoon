# 2294 동전
import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

coin = sorted(list(map(int, sys.stdin.read().splitlines())), reverse=True)
is_calc = [False] * (K + 1)


def bfs():
    Q = deque()
    Q.append(K)
    is_calc[K] = True
    
    count = -1
    while Q:
        count += 1
        length = len(Q)
        for _ in range(length):
            pop = Q.popleft()
            if pop == 0:
                print(count)
                return
            for c in coin:
                next_cost = pop - c
                if next_cost >= 0 and not is_calc[next_cost]:
                    is_calc[next_cost] = True
                    Q.append(next_cost)

    print(-1)


bfs()
