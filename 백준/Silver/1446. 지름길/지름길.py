import sys

N, D = map(int, sys.stdin.readline().split())

matrix = []

for _ in range(N):
    start, end, distance = map(int, sys.stdin.readline().split())
    matrix.append([start,end,distance])

matrix.sort()
dp = [i for i in range(D + 1)]

idx = 0
for i in range(D + 1):
    dp[i] = min(dp[i - 1] + 1, dp[i])
    while idx < N:
        start, end, distance = matrix[idx]
        if i == start:
            if end <= D:
                dp[end] = min(dp[i] + distance, dp[end])
            idx+=1
        else:
            break

print(dp[D])