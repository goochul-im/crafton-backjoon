# 11049 행렬 곱셈 순서
import sys

N = int(sys.stdin.readline())

matrix = [[] for _ in range(N + 1)]
dp = [[None for _ in range(N + 1)] for _ in range(N + 1)]

for i in range(1, N + 1):
    matrix[i] = list(map(int, sys.stdin.readline().split()))

for i in range(N + 1):
    dp[i][i] = 0
    dp[i][0] = 0
    dp[0][i] = 0


def dynamic(left, right):
    if left == right:
        return 0
    if dp[left][right] is not None:
        return dp[left][right]

    dp[left][right] = float('inf')
    for k in range(left, right):
        dp[left][right] = min(dp[left][right],
                              dynamic(left, k) + dynamic(k + 1, right) + (
                                          matrix[left][0] * matrix[k][1] * matrix[right][1]))

    return dp[left][right]


result = dynamic(1, N)
print(result)
