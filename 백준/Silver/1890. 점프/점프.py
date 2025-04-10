# 1890 점프
import sys

sys.setrecursionlimit(3000000)

N = int(sys.stdin.readline())

prob = []

for _ in range(N):
    prob.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * N for _ in range(N)]


def dynamic(row, col):
    count = 0

    if row == N - 1 and col == N - 1:
        return 1

    if dp[row][col]:
        return dp[row][col]

    if prob[row][col] == 0:
        return 0
    next_row = row + prob[row][col]
    next_col = col + prob[row][col]
    if next_row < N:
        count += dynamic(next_row, col)
    if next_col < N:
        count += dynamic(row, next_col)

    dp[row][col] = count

    return count


print(dynamic(0, 0))
