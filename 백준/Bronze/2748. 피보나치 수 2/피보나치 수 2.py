# 2748 피보나치 수 2
import sys

N = int(sys.stdin.readline())

lst = [0 for _ in range(N + 1)]
lst[1] = 1

for i in range(2, N + 1):
    lst[i] = lst[i - 1] + lst[i - 2]


print(lst[N])
