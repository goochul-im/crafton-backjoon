# 2579 계단 오르기
import sys

N = int(sys.stdin.readline())
stairs = [0] * (N + 1)
for i in range(1, N + 1):
    stairs[i] = int(sys.stdin.readline())
# 0번 row는 이전에 1칸 올라왔을 때
# 1번 row는 이전에 2칸 올라왔을 때
dp = [[0] * (N + 1) for _ in range(2)]

dp[1][1] = stairs[1]
if N > 1:
    dp[0][2] = stairs[1] + stairs[2]
    dp[1][2] = stairs[2]

for i in range(3, N + 1):
    dp[0][i] = dp[1][i - 1] + stairs[i]  # 이전에 1칸을 이미 올라온 상태에서 또 1칸을 올라올수 없다
    dp[1][i] = max(dp[0][i - 2], dp[1][i - 2]) + stairs[i]

print(max(dp[0][N], dp[1][N]))
