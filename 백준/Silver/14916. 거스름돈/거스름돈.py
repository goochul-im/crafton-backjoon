# 14916 거스름돈
import sys

N = int(sys.stdin.readline())
INF = int(1e9)
dp = [[INF] * (N + 1) for _ in range(2)]

if N > 1:
    dp[0][2] = 1
if N > 4:
    dp[1][5] = 1

for k in range(4, N + 1):
    dp[0][k] = min(dp[0][k - 2], dp[1][k - 2]) + 1
    if k - 5 > 0:
        dp[1][k] = min(dp[0][k - 5], dp[1][k - 5]) + 1

result = min(dp[0][N], dp[1][N])
print(result if result < INF else -1)
