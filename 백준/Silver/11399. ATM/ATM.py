# 11399 ATM
import sys

N = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.readline().split()))

prob.sort()

result = 0
now = 0
for p in prob:
    now += p
    result += now

print(result)
