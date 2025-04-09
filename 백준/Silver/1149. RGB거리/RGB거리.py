# 1149 RGB 거리
import sys

N = int(sys.stdin.readline())

RGB = [[] for i in range(N + 1)]

for i in range(N):
    RGB[i + 1] = list(map(int, sys.stdin.readline().split()))

dp = [[0] * N for _ in range(N + 1)]

dp[1][0] = RGB[1][0]
dp[1][1] = RGB[1][1]
dp[1][2] = RGB[1][2]

for i in range(2, N + 1):
    for j in range(3):
        dp[i][j] = min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + RGB[i][j]

print(min([dp[N][row] for row in range(3)]))
