# 2839 설탕 배달
import sys

N = int(sys.stdin.readline())

INF = int(1e9)
dp = [[INF] * (N + 1) for _ in range(2)]

dp[0][3] = 1
if N > 4:
    dp[1][5] = 1

for i in range(6, N + 1):
    dp[0][i] = min(dp[0][i - 3], dp[1][i - 3]) + 1
    dp[1][i] = min(dp[0][i - 5], dp[1][i - 5]) + 1


print(min(dp[0][N], dp[1][N]) if min(dp[0][N], dp[1][N]) < INF else -1)
