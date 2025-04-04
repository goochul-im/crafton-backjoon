# 11047 동전 0
import sys

N, K = map(int, sys.stdin.readline().split())

coins = list(map(int, sys.stdin.read().splitlines()))

COUNT = 0
IDX = len(coins) - 1

while K > 0:
    if K < coins[IDX]:
        for c in range(IDX - 1, -1, -1):
            if K >= coins[c]:
                IDX = c
                break

    divide_count = K // coins[IDX]
    remain_count = K % (coins[IDX] * divide_count)
    COUNT += divide_count
    K = remain_count

print(COUNT)
