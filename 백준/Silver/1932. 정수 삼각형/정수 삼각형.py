# 1932 정수 삼각형
import sys

N = int(sys.stdin.readline())

triangle = [[] for _ in range(N)]
dp = [[0] * i for i in range(1, N + 1)]

for i in range(N):
    triangle[i] = list(map(int, sys.stdin.readline().split()))

dp[0][0] = triangle[0][0]

for i in range(1, N):
    for j in range(i + 1):
        if j == 0:
            dp[i][j] = dp[i - 1][j] + triangle[i][j]
        elif j == i:
            dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]

print(max([dp[N - 1][row] for row in range(N)]))


