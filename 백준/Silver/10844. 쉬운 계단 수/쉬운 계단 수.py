# 10844 쉬운 계단 수
import sys

N = int(sys.stdin.readline())

dp = [[0] * 10 for _ in range(N + 1)]

for i in range(10):
    dp[1][i] = 1

for n in range(2, N + 1):
    for k in range(10):
        if 0 < k < 9:
            dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k + 1]) % 1000000000
        elif k == 0:
            dp[n][k] = dp[n - 1][k + 1] % 1000000000
        else:
            dp[n][k] = dp[n - 1][k - 1] % 1000000000

print(sum([dp[N][row] for row in range(1, 10)]) % 1000000000)
