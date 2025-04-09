# 1912 연속합
import sys

N = int(sys.stdin.readline())

prob = list(map(int, sys.stdin.readline().split()))
dp = [0 for i in range(N)]
dp[0] = prob[0]

for i in range(1, N):
    dp[i] = max(dp[i-1] + prob[i], prob[i])

print(max(dp))
