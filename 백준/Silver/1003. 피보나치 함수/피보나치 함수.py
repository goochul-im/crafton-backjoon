# 1003 피보나치 함수
import sys

T = int(sys.stdin.readline())

dp = [[0, 0] for _ in range(41)]
dp[0] = [1, 0]
dp[1] = [0, 1]


for _ in range(T):
    N = int(sys.stdin.readline())

    for i in range(2, N + 1):
        dp[i] = [dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]]

    print(*dp[N])




