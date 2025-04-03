# 1904 01 타일
import sys

N = int(sys.stdin.readline())

dp = [0 for _ in range(N + 1)]
if N >= 2:
    dp[1], dp[2] = 1, 2
else:
    dp[1] = 1
    

for i in range(3, N + 1):
    dp[i] = (dp[i-1] % 15746 + dp[i-2] % 15746) % 15746

print(dp[N])
